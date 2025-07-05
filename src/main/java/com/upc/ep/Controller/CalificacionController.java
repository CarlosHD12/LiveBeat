package com.upc.ep.Controller;

import com.upc.ep.DTO.CalificacionDTO;
import com.upc.ep.Entidad.Calificacion;
import com.upc.ep.Services.CalificacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LiveBeat")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true",
        exposedHeaders = "Authorization",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        allowedHeaders = "*"
)
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/organizador/calificar")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public CalificacionDTO saveCa(@RequestBody CalificacionDTO calificacionDTO) {
        Calificacion calificacion = modelMapper.map(calificacionDTO, Calificacion.class);
        calificacion = calificacionService.saveCa(calificacion);
        return modelMapper.map(calificacion, CalificacionDTO.class);
    }
}
