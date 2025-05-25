package com.upc.ep.Services;

import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Organizador;

import java.time.LocalDate;
import java.util.List;

public interface OrganizadorService {
    public Organizador saveO(Organizador organizador);
    public List<HU07DTO> hu07DTO(String Genero);
    public List<HU09DTO> hu09DTO();
    public List<HU10DTO> hu10DTO(LocalDate Fecha);
    public List<HU11DTO> hu11DTO(Long idOrganizador);
    public List<HU12DTO> hu12DTO(LocalDate startDate, LocalDate endDate);
    public List<HU13DTO> hu13DTO(Long idEvento);
    public List<HU14DTO> hu14DTO(Long idContrato);
    public List<HU15DTO> hu15DTO();
    public List<HU16DTO> hu16DTO(Long idArtista);
}
