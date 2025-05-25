package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HU12DTO {
    private Long idCo;
    private Boolean estado;
    private LocalDate fechaContrato;
    private Double montoTotal;
    private String nombreEvento;
}
