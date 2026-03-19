package com.sala_conciertos.controlador;


import com.sala_conciertos.modelo.Espectador;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sala-conciertos/espectadores")
public class EspectadorController {
    private final com.sala_conciertos.servicio.EspectadorService espectadorService;

    public EspectadorController(com.sala_conciertos.servicio.EspectadorService espectadorService) {
        this.espectadorService = espectadorService;
    }

    @GetMapping
    public List<Espectador> buscarTodos() {
        return espectadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Espectador> buscarPorId(@PathVariable Long id) {
        return espectadorService.buscarPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Espectador> buscarPorNombre(@PathVariable String nombre) {
        return espectadorService.buscarPorNombre(nombre);
    }

    @GetMapping("/email/{email}")
    public Espectador buscarPorEmail(@PathVariable String email) {
        return espectadorService.buscarPorEmail(email);
    }

    @PostMapping
    public ResponseEntity<Espectador> guardar(@Valid @RequestBody Espectador espectador) {
        Espectador nuevoEspectador = espectadorService.guardar(espectador);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEspectador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Espectador> actualizar(@PathVariable Long id, @Valid @RequestBody Espectador espectador){

        Espectador espectadorActualizado = espectadorService.actualizar(id, espectador);
        return ResponseEntity.status(HttpStatus.OK).body(espectadorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        espectadorService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
