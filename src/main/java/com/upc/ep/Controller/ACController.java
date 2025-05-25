package com.upc.ep.Controller;

import com.upc.ep.DTO.ACDTO;
import com.upc.ep.Entidad.AC;
import com.upc.ep.Services.ACService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LiveBeat")
public class ACController {
    @Autowired
    private ACService acService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/artista/contratos")
    @PreAuthorize("hasRole('ARTISTA')")
    public ACDTO saveAC(@RequestBody ACDTO acdto) {
        AC ac = modelMapper.map(acdto, AC.class);
        ac = acService.saveAC(ac);
        return modelMapper.map(ac, ACDTO.class);
    }
}
