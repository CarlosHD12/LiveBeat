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
public class HU25DTO {
    private String nombreEvento;
    private String direccion;
    private LocalDate fecha;
    private String tipoEvento;
}
