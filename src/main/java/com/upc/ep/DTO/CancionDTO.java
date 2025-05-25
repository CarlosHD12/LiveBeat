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
public class CancionDTO implements Serializable {
    private Long idC;

    private String titulo;
    private Double duracion;

    private ArtistaDTO artista;
}
