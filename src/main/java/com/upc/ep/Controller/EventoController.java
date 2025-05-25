package com.upc.ep.Controller;

import com.upc.ep.DTO.EventoDTO;
import com.upc.ep.Entidad.Evento;
import com.upc.ep.Services.EventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LiveBeat")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/organizador/eventos")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public EventoDTO saveE(@RequestBody EventoDTO eventoDTO) {
        Evento evento = modelMapper.map(eventoDTO, Evento.class);
        evento = eventoService.saveE(evento);
        return modelMapper.map(evento, EventoDTO.class);
    }
}
