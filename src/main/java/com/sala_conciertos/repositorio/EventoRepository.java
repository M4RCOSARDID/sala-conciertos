package com.sala_conciertos.repositorio;

import com.sala_conciertos.modelo.Evento;
import com.sala_conciertos.modelo.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    //Encontrar un evento por nombre
    //Select * from eventos where nombre = ?;
    Evento findByNombre(String nombre);

    //Encontrar un evento por fecha y hora
    //Select * from eventos where fecha_hora_evento = ?;
    Evento findByFechaHoraEvento(String fechaHoraEvento);

    //Encontrar eventos por precio de taquilla
    //Select * from eventos where precio_taquilla = ?;
    List<Evento> findByPrecioTaquilla(double precioTaquilla);

    //Encontrar evento mas baratos de X precio
    //Select * from eventos where precio_taquilla < ? ;
    List<Evento> findByPrecioTaquillaLessThan(double precioTaquilla);

    //Encontrar todos los eventos de un tipo
    //Select * from eventos where tipo_evento = ?;
    List<Evento> findByTipoEvento(TipoEvento tipoEvento);



}
