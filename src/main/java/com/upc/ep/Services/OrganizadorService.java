package com.upc.ep.Services;

import com.upc.ep.DTO.HU07DTO;
import com.upc.ep.DTO.HU16DTO;
import com.upc.ep.Entidad.Organizador;

import java.util.List;

public interface OrganizadorService {
    public Organizador saveO(Organizador organizador);
    public List<HU07DTO> hu07DTO(String Genero);
    public List<HU16DTO> hu16DTO(Long idArtista);
}
