package com.sala_conciertos.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "entradas")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La zona no puede estar en blanco")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoZona zona;

    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime fechaHoraCompra;

    @PositiveOrZero(message = "La fila no puede ser negativa")
    private Long fila;

    @PositiveOrZero(message = "El asiento no puede ser negativo")
    private Long asiento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEntrada tipoEntrada;

    @PositiveOrZero(message = "El precio no puede ser negativo")
    @Column(nullable = false)
    private double precioTotal;

    @Column(nullable = false)
    private boolean validada;

    @ManyToOne
    @JoinColumn(name = "espectador_id", nullable = false)
    private Espectador espectador;

    @ManyToOne
    @JoinColumn(name = "evento_id" , nullable = false)
    private Evento evento;

}
