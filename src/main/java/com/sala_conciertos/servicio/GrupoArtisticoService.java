package com.sala_conciertos.servicio;

import com.sala_conciertos.modelo.GrupoArtistico;
import com.sala_conciertos.modelo.TipoGrupoArtistico;
import com.sala_conciertos.repositorio.GrupoArtisticoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoArtisticoService {
    
    private final GrupoArtisticoRepository repositorio;

    public GrupoArtisticoService(GrupoArtisticoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<GrupoArtistico> listarTodos() {
        return repositorio.findAll();
    }

    public Optional<GrupoArtistico> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    public GrupoArtistico buscarPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public List<GrupoArtistico> buscarPorNumeroDeIntegrantes(int numeroIntegrantes){
        return repositorio.findByNumeroIntegrantes(numeroIntegrantes);
    }

    public List<GrupoArtistico> buscarPorGenero(String genero){
        return repositorio.findByGenero(genero);
    }

    public List<GrupoArtistico> buscarPorAnioFundacion(int anioFundacion){
        return repositorio.findByAnioFundacion(anioFundacion);
    }
    public List<GrupoArtistico> buscarPorPais(String pais) {
        return repositorio.findByPais(pais);
    }

    public List<GrupoArtistico> buscarPorTipo(TipoGrupoArtistico tipoGrupoArtistico){
        return repositorio.findByTipoGrupoArtistico(tipoGrupoArtistico);
    }

    @Transactional
    public GrupoArtistico guardar(GrupoArtistico grupo) {
        return repositorio.save(grupo);
    }

    @Transactional
    public GrupoArtistico actualizar(Long id, GrupoArtistico grupoActualizado) {
        return repositorio.findById(id).map(grupo -> {
            grupo.setNombre(grupoActualizado.getNombre());
            grupo.setGenero(grupoActualizado.getGenero());
            grupo.setNumeroIntegrantes(grupoActualizado.getNumeroIntegrantes());
            return repositorio.save(grupo);
        }).orElseThrow(() -> new RuntimeException("Grupo artístico no encontrado"));
    }

    @Transactional
    public void eliminar(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
        } else {
            throw new RuntimeException("Grupo artístico no encontrado");
        }
    }

}
