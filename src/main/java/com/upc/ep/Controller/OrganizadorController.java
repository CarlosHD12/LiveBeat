package com.upc.ep.Controller;

import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Organizador;
import com.upc.ep.Services.OrganizadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/organizador/HU09")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU09DTO> hu09DTO(){
        return organizadorService.hu09DTO();
    }

    @GetMapping("/organizador/HU10/{Fecha}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU10DTO> hu10DTO(@PathVariable("Fecha") LocalDate Fecha){
        return organizadorService.hu10DTO(Fecha);
    }

    @GetMapping("/organizador/HU11/{idOrganizador}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU11DTO> hu11DTO(@PathVariable("idOrganizador") Long idOrganizador){
        return organizadorService.hu11DTO(idOrganizador);
    }

    @GetMapping("/organizador/HU12")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU12DTO> hu12DTO(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return organizadorService.hu12DTO(startDate, endDate);
    }

    @GetMapping("/organizador/HU13/{idEvento}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU13DTO> hu13DTO(@PathVariable("idEvento") Long idEvento){
        return organizadorService.hu13DTO(idEvento);
    }

    @GetMapping("/organizador/HU14/{idContrato}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU14DTO> hu14DTO(@PathVariable("idContrato") Long idContrato){
        return organizadorService.hu14DTO(idContrato);
    }

    @GetMapping("/organizador/HU15")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU15DTO> hu15DTO(){
        return organizadorService.hu15DTO();
    }

    @GetMapping("/organizador/HU16/{idArtista}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public List<HU16DTO> hu16DTO(@PathVariable("idArtista") Long idArtista){
        return organizadorService.hu16DTO(idArtista);
    }

    @PutMapping("/organizador/modificar/{id}")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public ResponseEntity<OrganizadorDTO> actualizarOrganizador(@PathVariable Long id, @RequestBody OrganizadorDTO organizadorDTO) {
        OrganizadorDTO actualizado = organizadorService.actualizarOrganizador(id, organizadorDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
