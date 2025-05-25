package com.upc.ep.ServicesIMPL;

import com.upc.ep.Entidad.Contrato;
import com.upc.ep.Repositorio.ContratoRepos;
import com.upc.ep.Services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoIMPL implements ContratoService {
    @Autowired
    private ContratoRepos contratoRepos;

    @Override
    public Contrato saveCo(Contrato contrato) {
        return contratoRepos.save(contrato);
    }
}
