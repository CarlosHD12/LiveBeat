package com.upc.ep.Services;

import com.upc.ep.DTO.CancionDTO;
import com.upc.ep.Entidad.Cancion;

public interface CancionService {
    public Cancion saveC(Cancion cancion);
    CancionDTO actualizarCancion(Long id, CancionDTO cancionDTO);
}
