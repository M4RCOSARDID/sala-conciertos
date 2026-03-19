package com.sala_conciertos.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bandas")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class GrupoArtistico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El genero no puede estar en blanco")
    @Column(nullable = false)
    private String genero;

    @NotNull(message = "El numero de integrantes no puede estar en blanco")
    @Positive(message = "El numero de integrantes debe ser mayor que cero")
    @Column(nullable = false)
    private int numeroIntegrantes;

    @Column(nullable = false)
    private int anioFundacion;

    @NotBlank(message = "El pais no puede estar en blanco")
    @Column(nullable = false)
    private String pais;

    @Enumerated(EnumType.STRING)
    private TipoGrupoArtistico tipoGrupoArtistico;

    @ManyToMany
    @JoinTable(
        name = "BandaEvento",
        joinColumns = @JoinColumn(name = "banda_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos = new ArrayList<>();







}
