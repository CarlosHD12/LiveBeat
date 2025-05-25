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
public class OrganizadorDTO implements Serializable {
    private Long idO;

    private String nombreOrganizador;
    private String direccion;
    private String organizacion;
}
