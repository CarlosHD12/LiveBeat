package com.upc.ep.Entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;

    private String titulo;
    private Double duracion;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;
}
