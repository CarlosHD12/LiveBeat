package com.upc.ep.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ACDTO {
    private Long idAC;

    private ArtistaDTO artista;

    private ContratoDTO contrato;
}
