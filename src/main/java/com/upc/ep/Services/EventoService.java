package com.upc.ep.Services;

import com.upc.ep.DTO.EventoDTO;
import com.upc.ep.Entidad.Evento;

public interface EventoService {
    public Evento saveE(Evento evento);
    EventoDTO actualizarEvento(Long id, EventoDTO eventoDTO);
}
