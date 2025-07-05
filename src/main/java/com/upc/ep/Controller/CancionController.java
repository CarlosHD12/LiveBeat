package com.upc.ep.Controller;

import com.upc.ep.DTO.ArtistaDTO;
import com.upc.ep.DTO.CancionDTO;
import com.upc.ep.Entidad.Artista;
import com.upc.ep.Entidad.Cancion;
import com.upc.ep.Services.CancionService;
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

    @GetMapping("/canciones")
    @PreAuthorize("hasRole('ARTISTA')")
    public List<CancionDTO> listarC() {
        List<Cancion> canciones = cancionService.listarC();
        ModelMapper modelMapper = new ModelMapper();
        return canciones.stream()
                .map(cancion -> modelMapper.map(cancion, CancionDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/artista/modificar/cancion/{id}")
    @PreAuthorize("hasRole('ARTISTA')")
    public ResponseEntity<CancionDTO> actualizarCancion(@PathVariable Long id, @RequestBody CancionDTO cancionDTO) {
        CancionDTO actualizado = cancionService.actualizarCancion(id, cancionDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}