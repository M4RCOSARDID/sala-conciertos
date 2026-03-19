package com.sala_conciertos.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espectadores")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Espectador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 9, max = 9)
    @NotBlank(message = "El DNI no puede estar en blanco")
    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "El email no puede estar en blanco")
    @Column(nullable = false, unique = true)
    private String email;

}
