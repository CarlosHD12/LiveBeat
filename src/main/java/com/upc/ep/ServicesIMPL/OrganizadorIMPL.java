package com.upc.ep.ServicesIMPL;

import com.upc.ep.DTO.HU07DTO;
import com.upc.ep.DTO.HU16DTO;
import com.upc.ep.Entidad.Organizador;
import com.upc.ep.Repositorio.OrganizadorRepos;
import com.upc.ep.Services.OrganizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorIMPL implements OrganizadorService {
    @Autowired
    private OrganizadorRepos organizadorRepos;

    @Override
    public Organizador saveO(Organizador organizador) {
        return organizadorRepos.save(organizador);
    }

    @Override
    public List<HU07DTO> hu07DTO(String Genero) {
        return organizadorRepos.hu07DTO(Genero);
    }

    @Override
    public List<HU16DTO> hu16DTO(Long idArtista) {
        return organizadorRepos.hu16DTO(idArtista);
    }
}
