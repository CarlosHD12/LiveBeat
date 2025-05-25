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
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCo;

    private Boolean estado;
    private Double montoTotal;
    private LocalDate fechaContrato;

    @OneToOne
    @JoinColumn(name = "evento_id", unique = true)
    private Evento evento;
}
