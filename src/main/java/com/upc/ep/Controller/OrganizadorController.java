package com.upc.ep.Controller;

import com.upc.ep.DTO.HU07DTO;
import com.upc.ep.DTO.HU16DTO;
import com.upc.ep.DTO.OrganizadorDTO;
import com.upc.ep.Entidad.Organizador;
import com.upc.ep.Services.OrganizadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/LiveBeat")
public class OrganizadorController {
    @Autowired
    private OrganizadorService organizadorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/organizador")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public OrganizadorDTO saveO(@RequestBody OrganizadorDTO organizadorDTO) {
        Organizador organizador = modelMapper.map(organizadorDTO, Organizador.class);
        organizador = organizadorService.saveO(organizador);
        return modelMapper.map(organizador, OrganizadorDTO.class);
    }

    @GetMapping("/organizador/HU07/{Genero}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU07DTO> hu07DTO(@PathVariable("Genero") String Genero){
        return organizadorService.hu07DTO(Genero);
    }
    @GetMapping("/organizador/HU16/{idArtista}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU16DTO> hu16DTO(@PathVariable("idArtista") Long idArtista){
        return organizadorService.hu16DTO(idArtista);
    }
}
