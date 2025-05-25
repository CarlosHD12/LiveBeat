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
public class HU13DTO {
    private Long idP;
    private LocalDate fechaPago;
    private Double monto;
    private Boolean estadoPago;
    private Long idE;
}
