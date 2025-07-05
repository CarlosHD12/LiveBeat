package com.upc.ep.Controller;

import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Artista;
import com.upc.ep.Services.ArtistaService;
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

    @GetMapping("/artistas")
    @PreAuthorize("hasRole('ARTISTA') or hasRole('ORGANIZADOR')")
    public List<ArtistaDTO> listar() {
        List<Artista> artistas = artistaService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return artistas.stream()
                .map(artista -> modelMapper.map(artista, ArtistaDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/generos")
    @PreAuthorize("hasRole('ARTISTA') or hasRole('ORGANIZADOR')")
    public List<String> getGeneros() {
        return artistaService.getListaDeGeneros();
    }

    @GetMapping("/artista/HU22/{idArtista}")
    @PreAuthorize("hasRole('ARTISTA')")
    public List<HU22DTO> hu22DTO(@PathVariable("idArtista") Long idArtista){
        return artistaService.hu22DTO(idArtista);
    }

    @GetMapping("/artista/HU23/{idArtista}")
    @PreAuthorize("hasRole('ARTISTA')")
    public List<HU23DTO> hu23DTO(@PathVariable("idArtista") Long idArtista){
        return artistaService.hu23DTO(idArtista);
    }

    @GetMapping("/artista/HU24/{idArtista}")
    @PreAuthorize("hasRole('ARTISTA')")
    public List<HU24DTO> hu24DTO(@PathVariable("idArtista") Long idArtista){
        return artistaService.hu24DTO(idArtista);
    }

    @GetMapping("/artista/HU25")
    @PreAuthorize("hasRole('ARTISTA')")
    public List<HU25DTO> hu25DTO(){
        return artistaService.hu25DTO();
    }

    @GetMapping("/artista/HU26/{idArtista}")
    @PreAuthorize("hasRole('ARTISTA')")
    public List<HU26DTO> hu26DTO(@PathVariable("idArtista") Long idArtista){
        return artistaService.hu26DTO(idArtista);
    }

    @PutMapping("/artista/modificar/{id}")
    @PreAuthorize("hasRole('ARTISTA')")
    public ResponseEntity<ArtistaDTO> actualizarArtista(@PathVariable Long id, @RequestBody ArtistaDTO artistaDTO) {
        ArtistaDTO actualizado = artistaService.actualizarArtista(id, artistaDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @PutMapping("/artista/disponible/{id}")
    @PreAuthorize("hasRole('ARTISTA')")
    public ResponseEntity<ArtistaDTO> actualizarDisponible(@PathVariable Long id, @RequestBody ArtistaDTO artistaDTO) {
        ArtistaDTO actualizado2 = artistaService.actualizarDisponible(id, artistaDTO);
        return new ResponseEntity<>(actualizado2, HttpStatus.OK);
    }
}