package com.upc.ep.Controller;

import com.upc.ep.DTO.ContratoDTO;
import com.upc.ep.Entidad.Contrato;
import com.upc.ep.Services.ContratoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LiveBeat")
public class ContratoController {
    @Autowired
    private ContratoService contratoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/eventos/contrato")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public ContratoDTO saveE(@RequestBody ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contrato = contratoService.saveCo(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }
}
