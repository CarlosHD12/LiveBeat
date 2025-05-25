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
public class HU22DTO {
    private Long idA;
    private String nombreEvento;
    private LocalDate fechaContrato;
    private Double montoTotal;
}
