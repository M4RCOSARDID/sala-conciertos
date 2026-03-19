package com.sala_conciertos.repositorio;

import com.sala_conciertos.modelo.GrupoArtistico;
import com.sala_conciertos.modelo.TipoGrupoArtistico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoArtisticoRepository extends JpaRepository<GrupoArtistico, Long> {

    //Encontrar una banda por nombre
    //Select * from bandas where nombre = ?;
    GrupoArtistico findByNombre(String nombre);

    //Encontrar una banda por genero
    //Select * from bandas where genero = ?;
    List<GrupoArtistico> findByGenero(String genero);

    //Encontrar una banda por año de fundación
    //Select * from bandas where anio_fundacion = ?;
    List<GrupoArtistico> findByAnioFundacion(int anioFundacion); // Pongo Anio para que no haya conflictos con la "ñ"

    //Encontrar una banda por pais
    //Select * from bandas where pais = ?;
    List<GrupoArtistico> findByPais(String pais);

    //Encontrar una banda por el numero de integrantes
    //Select * from bandas where numero_integrantes = ?;
    List<GrupoArtistico> findByNumeroIntegrantes(int numeroIntegrantes);

    //Encontrar una lista de bandas por tipo
    //Select * from bandas where tipo = ?;
    List<GrupoArtistico> findByTipoGrupoArtistico(TipoGrupoArtistico tipoGrupoArtistico);


}
