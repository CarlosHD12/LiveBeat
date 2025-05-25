package com.upc.ep.Controller;

import com.upc.ep.DTO.ArtistaDTO;
import com.upc.ep.Entidad.Artista;
import com.upc.ep.Services.ArtistaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/LiveBeat")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/artista")
    @PreAuthorize("hasRole('ARTISTA')")
    public ArtistaDTO saveA(@RequestBody ArtistaDTO artistaDTO) {
        Artista artista = modelMapper.map(artistaDTO, Artista.class);
        artista = artistaService.saveA(artista);
        return modelMapper.map(artista, ArtistaDTO.class);
    }




}