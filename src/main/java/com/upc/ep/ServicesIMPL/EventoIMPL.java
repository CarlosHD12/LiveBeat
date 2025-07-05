package com.upc.ep.ServicesIMPL;

import com.upc.ep.DTO.EventoDTO;
import com.upc.ep.Entidad.Evento;
import com.upc.ep.Entidad.Organizador;
import com.upc.ep.Repositorio.EventoRepos;
import com.upc.ep.Services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoIMPL implements EventoService {
    @Autowired
    private EventoRepos eventoRepos;

    @Override
    public Evento saveE(Evento evento) {
        return eventoRepos.save(evento);
    }

    @Override
    public List<Evento> listar() {
        return eventoRepos.findAll();
    }

    @Override
    public EventoDTO actualizarEvento(Long id, EventoDTO eventoDTO) {
        Evento evento = eventoRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con ID: " + id));

        evento.setNombreEvento(eventoDTO.getNombreEvento());
        evento.setFecha(eventoDTO.getFecha());
        evento.setTipoEvento(eventoDTO.getTipoEvento());
        evento.setDescripcion(eventoDTO.getDescripcion());

        Evento actualizado = eventoRepos.save(evento);

        EventoDTO dto = new EventoDTO();
        dto.setIdE(actualizado.getIdE());
        dto.setNombreEvento(actualizado.getNombreEvento());
        dto.setFecha(actualizado.getFecha());
        dto.setTipoEvento(actualizado.getTipoEvento());
        dto.setDescripcion(actualizado.getDescripcion());

        return dto;
    }
}
