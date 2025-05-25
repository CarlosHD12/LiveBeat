package com.upc.ep.ServicesIMPL;

import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Artista;
import com.upc.ep.Repositorio.ArtistaRepos;
import com.upc.ep.Services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaIMPL implements ArtistaService {
    @Autowired
    private ArtistaRepos artistaRepos;

    @Override
    public Artista saveA(Artista artista) {
        return artistaRepos.save(artista);
    }

    @Override
    public List<HU22DTO> hu22DTO(Long idArtista) {
        return artistaRepos.hu22DTO(idArtista);
    }

    @Override
    public List<HU23DTO> hu23DTO(Long idArtista) {
        return artistaRepos.hu23DTO(idArtista);
    }

    @Override
    public List<HU24DTO> hu24DTO(Long idArtista) {
        return artistaRepos.hu24DTO(idArtista);
    }

    @Override
    public List<HU25DTO> hu25DTO() {
        return artistaRepos.hu25DTO();
    }

    @Override
    public List<HU26DTO> hu26DTO(Long idArtista) {
        return artistaRepos.hu26DTO(idArtista);
    }

    @Override
    public ArtistaDTO actualizarArtista(Long id, ArtistaDTO artistaDTO) {
        Artista artista = artistaRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado con ID: " + id));

        artista.setNombreArtista(artistaDTO.getNombreArtista());
        artista.setGenero(artistaDTO.getGenero());
        artista.setBiografia(artistaDTO.getBiografia());
        artista.setCanciones(artistaDTO.getCanciones());

        Artista artistaActualizado = artistaRepos.save(artista);

        ArtistaDTO dtoActualizado = new ArtistaDTO();
        dtoActualizado.setIdA(artistaActualizado.getIdA());
        dtoActualizado.setNombreArtista(artistaActualizado.getNombreArtista());
        dtoActualizado.setGenero(artistaActualizado.getGenero());
        dtoActualizado.setBiografia(artistaActualizado.getBiografia());
        dtoActualizado.setCanciones(artistaActualizado.getCanciones());

        return dtoActualizado;
    }

    @Override
    public ArtistaDTO actualizarDisponible(Long id, ArtistaDTO artistaDTO) {
        Artista artista = artistaRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista no encontrado con ID: " + id));
        artista.setDisponible(artistaDTO.getDisponible());

        Artista artistaActualizado = artistaRepos.save(artista);

        ArtistaDTO dtoActualizado2 = new ArtistaDTO();
        dtoActualizado2.setIdA(artistaActualizado.getIdA());
        dtoActualizado2.setDisponible(artistaActualizado.getDisponible());

        return dtoActualizado2;
    }
}


