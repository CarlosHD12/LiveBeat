package com.upc.ep.Services;

import com.upc.ep.DTO.EventoDTO;
import com.upc.ep.Entidad.Evento;

import java.util.List;

public interface EventoService {
    public Evento saveE(Evento evento);
    public List<Evento> listar();
    EventoDTO actualizarEvento(Long id, EventoDTO eventoDTO);
}
