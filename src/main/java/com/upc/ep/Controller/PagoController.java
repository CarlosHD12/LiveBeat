package com.upc.ep.Controller;

import com.upc.ep.DTO.PagoDTO;
import com.upc.ep.Entidad.Pago;
import com.upc.ep.Services.PagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LiveBeat")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/contrato/pagos")
    @PreAuthorize("hasRole('ORGANIZADOR')")
    public PagoDTO saveAC(@RequestBody PagoDTO pagoDTO) {
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pago = pagoService.saveP(pago);
        return modelMapper.map(pago, PagoDTO.class);
    }
}
