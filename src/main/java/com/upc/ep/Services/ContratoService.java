package com.upc.ep.Services;

import com.upc.ep.Entidad.Contrato;

import java.util.List;

public interface ContratoService {
    public Contrato saveCo(Contrato contrato);
    public List<Contrato> listar();
}
