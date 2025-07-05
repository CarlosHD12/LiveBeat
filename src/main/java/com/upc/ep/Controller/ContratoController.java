package com.upc.ep.Controller;

import com.upc.ep.DTO.ContratoDTO;
import com.upc.ep.Entidad.Contrato;
import com.upc.ep.Services.ContratoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/contratos")
    @PreAuthorize("hasRole('ARTISTA') or hasRole('ORGANIZADOR')")
    public List<ContratoDTO> listar() {
        List<Contrato> contratos = contratoService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return contratos.stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }
}
