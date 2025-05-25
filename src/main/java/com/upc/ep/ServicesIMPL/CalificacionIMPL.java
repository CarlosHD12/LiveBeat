package com.upc.ep.ServicesIMPL;

import com.upc.ep.Entidad.Calificacion;
import com.upc.ep.Repositorio.CalificacionRepos;
import com.upc.ep.Services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionIMPL implements CalificacionService {
    @Autowired
    private CalificacionRepos calificacionRepos;

    @Override
    public Calificacion saveCa(Calificacion calificacion) {
        return calificacionRepos.save(calificacion);
    }
}
