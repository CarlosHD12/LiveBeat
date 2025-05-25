package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HU07DTO {
    private Long idA;
    private String nombreArtista;
    private String genero;
    private Boolean disponible;
}
