package com.upc.ep.ServicesIMPL;

import com.upc.ep.Entidad.Evento;
import com.upc.ep.Repositorio.EventoRepos;
import com.upc.ep.Services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoIMPL implements EventoService {
    @Autowired
    private EventoRepos eventoRepos;

    @Override
    public Evento saveE(Evento evento) {
        return eventoRepos.save(evento);
    }
}
