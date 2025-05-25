package com.upc.ep.Controller;

import com.upc.ep.DTO.CancionDTO;
import com.upc.ep.Entidad.Cancion;
import com.upc.ep.Services.CancionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LiveBeat")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/artista/canciones")
    @PreAuthorize("hasRole('ARTISTA')")
    public CancionDTO saveC(@RequestBody CancionDTO cancionDTO) {
        Cancion cancion = modelMapper.map(cancionDTO, Cancion.class);
        cancion = cancionService.saveC(cancion);
        return modelMapper.map(cancion, CancionDTO.class);
    }
}