package com.sala_conciertos.servicio;

import com.sala_conciertos.modelo.Espectador;
import com.sala_conciertos.repositorio.EspectadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspectadorService {
    
    private final EspectadorRepository repositorio;
    
    public EspectadorService(EspectadorRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Optional<Espectador> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    

    public List<Espectador> listarTodos() {
        return repositorio.findAll();
    }

    @Transactional
    public Espectador guardar(Espectador espectador) {
        return repositorio.save(espectador);
    }

    @Transactional
    public void eliminar(Long id) {
        if(repositorio.existsById(id)) {
            repositorio.deleteById(id);
        }else{
            throw new RuntimeException("Espectador no encontrado");
        }
    }

    @Transactional
    public Espectador actualizar(Long id, Espectador espectadorActualizado) {

        return repositorio.findById(id).map(espectador -> {
            espectador.setDni(espectadorActualizado.getDni());
            espectador.setNombre(espectadorActualizado.getNombre());
            espectador.setEmail(espectadorActualizado.getEmail());
            return repositorio.save(espectador);
        }).orElseThrow(() -> new RuntimeException("Espectador no encontrado"));

    }

    public List<Espectador> buscarPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public Espectador buscarPorEmail(String email) {
        return repositorio.findByEmail(email);
    }

}
