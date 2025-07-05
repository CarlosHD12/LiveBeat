package com.upc.ep.Controller;

import com.upc.ep.DTO.ACDTO;
import com.upc.ep.Entidad.AC;
import com.upc.ep.Services.ACService;
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

    @GetMapping("/acs")
    @PreAuthorize("hasRole('ARTISTA') or hasRole('ORGANIZADOR')")
    public List<ACDTO> listar() {
        List<AC> acs = acService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return acs.stream()
                .map(ac -> modelMapper.map(ac, ACDTO.class))
                .collect(Collectors.toList());
    }
}
