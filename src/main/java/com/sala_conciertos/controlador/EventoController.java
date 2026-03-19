package com.sala_conciertos.controlador;

import com.sala_conciertos.modelo.TipoEvento;
import com.sala_conciertos.servicio.EventoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sala_conciertos.modelo.Evento;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/sala-conciertos/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> buscarTodos() {
        return eventoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Evento> buscarPorId(@PathVariable Long id) {
        return eventoService.buscarPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Evento buscarPorNombre(@PathVariable String nombre) {
        return eventoService.buscarPorNombre(nombre);
    }

    @GetMapping("/tipo/{tipoEvento}")
    public List<Evento> buscarPorTipo(@PathVariable TipoEvento tipoEvento) {
        return eventoService.buscarPorTipo(tipoEvento);
    }

    @GetMapping("/precio-menor/{precio}")
    public List<Evento> buscarPorPrecioMenorQue(@PathVariable double precio) {
        return eventoService.buscarPorPrecioMenor(precio);
    }

    @GetMapping("/precio/{precio}")
    public List<Evento> buscarPorPrecio(@PathVariable double precio) {
        return eventoService.buscarPorPrecioTaquilla(precio);
    }

    @PostMapping
    public ResponseEntity<Evento> guardar(@Valid @RequestBody Evento evento) {
        Evento nuevoEvento = eventoService.guardar(evento);
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(nuevoEvento);
    }

    @PutMapping("/{id}")
    public org.springframework.http.ResponseEntity<Evento> actualizar(@PathVariable Long id, @Valid @RequestBody Evento evento) {
        Evento eventoActualizado = eventoService.actualizar(id, evento);
        return org.springframework.http.ResponseEntity.ok(eventoActualizado);
    }

    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eventoService.eliminar(id);
        return org.springframework.http.ResponseEntity.noContent().build();
    }

}
