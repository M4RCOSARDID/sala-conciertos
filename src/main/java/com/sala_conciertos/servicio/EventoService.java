package com.sala_conciertos.servicio;

import com.sala_conciertos.modelo.Evento;
import com.sala_conciertos.modelo.TipoEvento;
import com.sala_conciertos.repositorio.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private EventoRepository repositorio;

    public EventoService(EventoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Optional<Evento> buscarPorId(Long id){
        return repositorio.findById(id);
    }

    public List<Evento> listarTodos(){
        return repositorio.findAll();
    }

    @Transactional
    public Evento guardar(Evento evento){
        return repositorio.save(evento);
    }

    @Transactional
    public void eliminar(Long id){
        repositorio.deleteById(id);
    }

    @Transactional
    public Evento actualizar(Long id, Evento evento){

        if(repositorio.existsById(id)){

            Evento eventoExistente = repositorio.findById(id).get();

            eventoExistente.setNombre(evento.getNombre());
            eventoExistente.setFechaHoraEvento(evento.getFechaHoraEvento());
            eventoExistente.setTipoEvento(evento.getTipoEvento());
            eventoExistente.setPrecioTaquilla(evento.getPrecioTaquilla());

            return repositorio.save(eventoExistente);

        }else{
            throw new RuntimeException("Evento no encontrado");
        }

    }

    public Evento buscarPorNombre(String nombre){
        return repositorio.findByNombre(nombre);
    }

    public Evento buscarPorFechaHora(String fechaHoraEvento){return repositorio.findByFechaHoraEvento(fechaHoraEvento); }

    public List<Evento> buscarPorPrecioTaquilla(double precioTaquilla){ return repositorio.findByPrecioTaquilla(precioTaquilla); }

    public List<Evento> buscarPorPrecioMenor (double precio){ return repositorio.findByPrecioTaquillaLessThan(precio); }

    public List<Evento> buscarPorTipo(TipoEvento tipoEvento){ return repositorio.findByTipoEvento(tipoEvento); }

}
