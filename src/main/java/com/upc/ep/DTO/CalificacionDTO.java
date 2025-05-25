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
public class CalificacionDTO implements Serializable {
    private Long idCa;

    private String comentario;
    private Boolean recomendacion;
    private Long valoracion;

    private OrganizadorDTO organizador;

    private ArtistaDTO artista;
}
