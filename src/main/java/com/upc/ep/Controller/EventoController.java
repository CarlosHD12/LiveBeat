package com.upc.ep.Controller;

import com.upc.ep.DTO.EventoDTO;
import com.upc.ep.Entidad.Evento;
import com.upc.ep.Services.EventoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/LiveBeat")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true",
        exposedHeaders = "Authorization",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        allowedHeaders = "*"
)
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

    @GetMapping("/eventos")
    @PreAuthorize("hasRole('ARTISTA') or hasRole('ORGANIZADOR')")
    public List<EventoDTO> listar() {
        List<Evento> eventos = eventoService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/organizador/modificar/evento/{id}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public ResponseEntity<EventoDTO> actualizarEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {
        EventoDTO actualizado = eventoService.actualizarEvento(id, eventoDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
