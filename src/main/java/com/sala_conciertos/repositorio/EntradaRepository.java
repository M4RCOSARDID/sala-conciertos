package com.sala_conciertos.repositorio;

import com.sala_conciertos.modelo.Entrada;
import com.sala_conciertos.modelo.TipoEntrada;
import com.sala_conciertos.modelo.TipoZona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    //Encontrar todas las entradas para un evento
    //Select * from entradas where evento_id = ?;
    List<Entrada> findByEvento(Long id);

    //Encontrar todas las entradas para un espectador
    //Select * from entradas where espectador_id = ?;
    List<Entrada> findByEspectador(Long id);

    //Encotrar todas las entradas del mismo tipo
    //Select * from entradas where tipo_entrada = ?;
    List<Entrada> findByTipoEntrada(TipoEntrada tipoEntrada);

    //Encontrar todas las entradas de una zona
    //Select * from entradas where zona = ?;
    List<Entrada> findByZona(TipoZona zona);

}
