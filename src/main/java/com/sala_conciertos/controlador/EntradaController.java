package com.sala_conciertos.controlador;

import com.sala_conciertos.modelo.Entrada;
import com.sala_conciertos.modelo.TipoEntrada;
import com.sala_conciertos.modelo.TipoZona;
import com.sala_conciertos.servicio.EntradaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/sala-conciertos/entradas")
public class EntradaController {

    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @GetMapping
    public List<Entrada> buscarTodas(){
        return entradaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Entrada buscarPorId(@PathVariable long id){
        return entradaService.buscarPorId(id).get();
    }

    @GetMapping("/zona/{zona}")
    public List<Entrada> buscarPorZona(@PathVariable TipoZona zona){
        return entradaService.buscarPorZona(zona);
    }

    @GetMapping("/TipoEntrada/{TipoEntrada}")
    public List<Entrada> buscarPorTipoEntrada(@PathVariable TipoEntrada tipoEntrada) {
        return entradaService.buscarPorTipoEntrada(tipoEntrada);
    }

    @GetMapping("/espectador/{id}")
    public List<Entrada> buscarPorEspectador(@PathVariable Long id) {
        return entradaService.buscarPorEspectador(id);
    }

    @GetMapping("/evento/{id}")
    public List<Entrada> buscarPorEvento(@PathVariable Long id) {return entradaService.buscarPorEvento(id); }

    @PostMapping
    public ResponseEntity guardar(@Valid @RequestBody Entrada entrada) {
        Entrada entradaNueva  = entradaService.guardar(entrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(entradaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id, @Valid @RequestBody Entrada entrada) {
        Entrada entradaActualizada = entradaService.actualizar(id, entrada);
        return ResponseEntity.status(HttpStatus.OK).body(entrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        entradaService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }






}
