package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HU24DTO {
    private Long idA;
    private String nombreOrganizador;
    private String comentario;
    private Long valoracion;
}
