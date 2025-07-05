package com.upc.ep.Services;

import com.upc.ep.Entidad.AC;

import java.util.List;

public interface ACService {
    public AC saveAC(AC ac);
    public List<AC> listar();
}
