package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO implements Serializable {
    private Long idCo;

    private Boolean estado;
    private Double montoTotal;
    private LocalDate fechaContrato;

    private EventoDTO evento;
}
