package com.sala_conciertos.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "La fecha y hora del evento no puede estar en blanco")
    private LocalDateTime fechaHoraEvento;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @PositiveOrZero(message = "El precio de la taquilla no puede ser negativo")
    @Column(nullable = false)
    private double precioTaquilla;

}
