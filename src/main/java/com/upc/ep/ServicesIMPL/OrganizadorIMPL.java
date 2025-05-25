package com.upc.ep.ServicesIMPL;

import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Organizador;
import com.upc.ep.Repositorio.OrganizadorRepos;
import com.upc.ep.Services.OrganizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<HU09DTO> hu09DTO() {
        return organizadorRepos.hu09DTO();
    }

    @Override
    public List<HU10DTO> hu10DTO(LocalDate Fechaa) {
        return organizadorRepos.hu10DTO(Fechaa);
    }

    @Override
    public List<HU11DTO> hu11DTO(Long idOrganizador) {
        return organizadorRepos.hu11DTO(idOrganizador);
    }

    @Override
    public List<HU12DTO> hu12DTO(LocalDate startDate, LocalDate endDate) {
        return organizadorRepos.hu12DTO(startDate, endDate);
    }

    @Override
    public List<HU13DTO> hu13DTO(Long idEvento) {
        return organizadorRepos.hu13DTO(idEvento);
    }

    @Override
    public List<HU14DTO> hu14DTO(Long idContrato) {
        return organizadorRepos.hu14DTO(idContrato);
    }

    @Override
    public List<HU15DTO> hu15DTO() {
        return organizadorRepos.hu15DTO();
    }

    @Override
    public List<HU16DTO> hu16DTO(Long idArtista) {
        return organizadorRepos.hu16DTO(idArtista);
    }
}
