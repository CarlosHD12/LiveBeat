package com.upc.ep.Services;

import com.upc.ep.DTO.CancionDTO;
import com.upc.ep.Entidad.Artista;
import com.upc.ep.Entidad.Cancion;

import java.util.List;

public interface CancionService {
    public Cancion saveC(Cancion cancion);
    public List<Cancion> listarC();
    CancionDTO actualizarCancion(Long id, CancionDTO cancionDTO);
}
