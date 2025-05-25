package com.upc.ep.ServicesIMPL;

import com.upc.ep.DTO.CancionDTO;
import com.upc.ep.Entidad.Artista;
import com.upc.ep.Entidad.Cancion;
import com.upc.ep.Repositorio.CancionRepos;
import com.upc.ep.Services.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancionIMPL implements CancionService {
    @Autowired
    private CancionRepos cancionRepos;

    @Override
    public Cancion saveC(Cancion cancion) {
        return cancionRepos.save(cancion);
    }

    @Override
    public CancionDTO actualizarCancion(Long id, CancionDTO cancionDTO) {
        Cancion cancion = cancionRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Canción no encontrada con ID: " + id));

        cancion.setTitulo(cancionDTO.getTitulo());
        cancion.setDuracion(cancionDTO.getDuracion());

        Cancion actualizada = cancionRepos.save(cancion);

        CancionDTO dto = new CancionDTO();
        dto.setIdC(actualizada.getIdC());
        dto.setTitulo(actualizada.getTitulo());
        dto.setDuracion(actualizada.getDuracion());

        return dto;
    }
}
