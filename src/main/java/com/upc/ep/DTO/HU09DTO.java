package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HU09DTO {
    private String nombreArtista;
    private String comentario;
    private Boolean recomendacion;
    private Long valoracion;
}
