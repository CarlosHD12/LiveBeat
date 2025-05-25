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
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;

    private LocalDate fechaPago;
    private Double monto;
    private Boolean estadoPago;
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;
}