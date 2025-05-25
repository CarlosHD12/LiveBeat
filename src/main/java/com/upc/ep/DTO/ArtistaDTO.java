package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistaDTO implements Serializable {
    private Long idA;

    private String nombreArtista;
    private String genero;
    private String biografia;
    private Boolean disponible;
    private Long canciones;
}
