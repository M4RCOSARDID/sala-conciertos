package com.sala_conciertos.controlador;

import com.sala_conciertos.modelo.GrupoArtistico;
import com.sala_conciertos.modelo.TipoGrupoArtistico;
import com.sala_conciertos.servicio.GrupoArtisticoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sala-conciertos/grupos-artisticos")
public class GrupoArtisticoController {
    private final GrupoArtisticoService grupoArtisticoService;

    public GrupoArtisticoController(GrupoArtisticoService grupoArtisticoService) {
        this.grupoArtisticoService = grupoArtisticoService;
    }

    @GetMapping
    public List<GrupoArtistico> buscarTodos() {
        return grupoArtisticoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<GrupoArtistico> buscarPorId(@PathVariable Long id) {
        return grupoArtisticoService.buscarPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public GrupoArtistico buscarPorNombre(@PathVariable String nombre) {
        return grupoArtisticoService.buscarPorNombre(nombre);
    }

    @GetMapping("/genero/{genero}")
    public List<GrupoArtistico> buscarPorGenero(@PathVariable String genero) {
        return grupoArtisticoService.buscarPorGenero(genero);
    }

    @GetMapping("/numeroIntegrantes/{numeroIntegrantes}")
    public List<GrupoArtistico> buscarPorNumeroDeIntegrantes(@PathVariable int numeroIntegrantes) {
        return grupoArtisticoService.buscarPorNumeroDeIntegrantes(numeroIntegrantes);
    }

    @GetMapping("/anioFundacion/{anioFundacion}")
    public List<GrupoArtistico> buscarPorAnioFundacion(@PathVariable int anioFundacion) {
        return grupoArtisticoService.buscarPorAnioFundacion(anioFundacion);
    }

    @GetMapping("/pais/{pais}")
    public List<GrupoArtistico> buscarPorPais(@PathVariable String pais) {
        return grupoArtisticoService.buscarPorPais(pais);
    }

    @GetMapping("TipoGrupoArtistico/{tipoGrupoArtistico}")
    public List<GrupoArtistico> buscarPorTipo(@PathVariable TipoGrupoArtistico tipoGrupoArtistico) {
        return grupoArtisticoService.buscarPorTipo(tipoGrupoArtistico);
    }


    @PostMapping
    public ResponseEntity<GrupoArtistico> guardar(@Valid @RequestBody GrupoArtistico grupo) {
        GrupoArtistico nuevoGrupo = grupoArtisticoService.guardar(grupo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGrupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoArtistico> actualizar(@PathVariable Long id, @Valid @RequestBody GrupoArtistico grupo) {
        GrupoArtistico grupoActualizado = grupoArtisticoService.actualizar(id, grupo);
        return ResponseEntity.ok(grupoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        grupoArtisticoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
