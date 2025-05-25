package com.upc.ep.Repositorio;


import com.upc.ep.DTO.HU07DTO;
import com.upc.ep.DTO.HU16DTO;
import com.upc.ep.Entidad.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizadorRepos extends JpaRepository<Organizador, Long> {

    //Como Organizador quiero ver Artistas Disponibles por Generos
    @Query("SELECT new com.upc.ep.DTO.HU07DTO(a.idA, a.nombreArtista, a.genero, a.disponible) " +
            "FROM Artista a " +
            "WHERE a.disponible = true AND a.genero = :Genero " +
            "ORDER BY a.nombreArtista")
    List<HU07DTO> hu07DTO(@Param("Genero") String Genero);

    //Como Organizador quiero ver las canciones por Artista que tenga como parametro su ID del Artista
    @Query("SELECT NEW com.upc.ep.DTO.HU16DTO(c.artista.idA, c.artista.nombreArtista, c.titulo) " +
            "FROM Cancion c " +
            "WHERE c.artista.idA = :idArtista")
    List<HU16DTO> hu16DTO(@Param("idArtista") Long idArtista);
}
