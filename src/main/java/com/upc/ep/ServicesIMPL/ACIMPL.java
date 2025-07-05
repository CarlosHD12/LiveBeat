package com.upc.ep.ServicesIMPL;

import com.upc.ep.Entidad.AC;
import com.upc.ep.Repositorio.ACRepos;
import com.upc.ep.Services.ACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ACIMPL implements ACService {
    @Autowired
    private ACRepos acRepos;

    @Override
    public AC saveAC(AC ac) {
        return acRepos.save(ac);
    }

    @Override
    public List<AC> listar() {
        return acRepos.findAll();
    }
}
