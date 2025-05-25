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
public class AC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAC;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;
}
