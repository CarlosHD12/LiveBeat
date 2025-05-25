package com.upc.ep.ServicesIMPL;

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
}
