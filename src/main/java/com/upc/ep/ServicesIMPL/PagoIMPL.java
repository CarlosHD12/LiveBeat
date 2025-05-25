package com.upc.ep.ServicesIMPL;

import com.upc.ep.Entidad.Pago;
import com.upc.ep.Repositorio.PagoRepos;
import com.upc.ep.Services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoIMPL implements PagoService {
    @Autowired
    private PagoRepos pagoRepos;

    @Override
    public Pago saveP(Pago pago) {
        return pagoRepos.save(pago);
    }
}
