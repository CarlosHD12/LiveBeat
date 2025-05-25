package com.upc.ep.Entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;

    private String nombreEvento;
    private LocalDate fecha;
    private String tipoEvento;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Organizador organizador;
}
