package com.upc.ep.Services;

import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Artista;

import java.util.List;

public interface ArtistaService {
    public Artista saveA(Artista artista);
    public List<HU22DTO> hu22DTO(Long idArtista);
    public List<HU23DTO> hu23DTO(Long idArtista);
    public List<HU24DTO> hu24DTO(Long idArtista);
    public List<HU25DTO> hu25DTO();
    public List<HU26DTO> hu26DTO(Long idArtista);
    ArtistaDTO actualizarArtista(Long id, ArtistaDTO artistaDTO);
    ArtistaDTO actualizarDisponible(Long id, ArtistaDTO artistaDTO);
}
