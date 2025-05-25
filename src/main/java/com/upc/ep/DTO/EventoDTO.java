package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO implements Serializable {
    private Long idE;

    private String nombreEvento;
    private LocalDate fecha;
    private String tipoEvento;
    private String descripcion;

    private OrganizadorDTO organizador;
}
