package com.upc.ep.ServicesIMPL;

import com.upc.ep.DTO.ArtistaDTO;
import com.upc.ep.Entidad.Artista;
import com.upc.ep.Repositorio.ArtistaRepos;
import com.upc.ep.Services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ArtistaIMPL implements ArtistaService {
    @Autowired
    private ArtistaRepos artistaRepos;

    @Override
    public Artista saveA(Artista artista) {
        return artistaRepos.save(artista);
    }

}
