package com.sala_conciertos.repositorio;

import com.sala_conciertos.modelo.Espectador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspectadorRepository extends JpaRepository<Espectador, Long> {

    //Encontrar un espectador por nombre
    //Select * from espectadores where nombre = ?;
    List<Espectador> findByNombre(String nombre);

    //Encontrar un espectador por email
    //Select * from espectadores where email = ?;
    Espectador findByEmail(String email);

}
