package com.upc.ep.Repositorio;


import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrganizadorRepos extends JpaRepository<Organizador, Long> {

    //Como Organizador quiero ver Artistas Disponibles por Generos
    @Query("SELECT new com.upc.ep.DTO.HU07DTO(a.idA, a.nombreArtista, a.genero, a.disponible) " +
            "FROM Artista a " +
            "WHERE a.disponible = true AND a.genero = :Genero " +
            "ORDER BY a.nombreArtista")
    List<HU07DTO> hu07DTO(@Param("Genero") String Genero);

    @Query("SELECT NEW com.upc.ep.DTO.HU09DTO(ca.artista.nombreArtista, ca.comentario, ca.recomendacion, ca.valoracion) " +
            "FROM Calificacion ca " +
            "WHERE ca.recomendacion = true " +
            "ORDER BY ca.valoracion DESC")
    List<HU09DTO> hu09DTO();

    //Como organizador quiero filtrar eventos por fecha
    @Query("SELECT NEW com.upc.ep.DTO.HU10DTO(e.idE, e.nombreEvento, e.fecha, e.tipoEvento, e.descripcion) " +
            "FROM Evento e " +
            "WHERE e.fecha = :Fecha")
    List<HU10DTO> hu10DTO(@Param("Fecha") LocalDate Fecha);

    //Como organizador quiero ver contratos pendientes = false, dado como parametro el Id de un Organizador
    @Query("SELECT NEW com.upc.ep.DTO.HU11DTO(co.evento.organizador.idO, co.idCo, co.estado, co.fechaContrato, co.montoTotal) " +
            "FROM Contrato co " +
            "WHERE co.estado = false AND co.evento.organizador.idO = :idOrganizador")
    List<HU11DTO> hu11DTO(@Param("idOrganizador") Long idOrganizador);

    //Como organizador quiero ver contratos de un rango de fechas
    @Query("SELECT NEW com.upc.ep.DTO.HU12DTO(co.idCo, co.estado, co.fechaContrato, co.montoTotal, co.evento.nombreEvento) " +
            "FROM Contrato co " +
            "WHERE co.fechaContrato BETWEEN :startDate AND :endDate")
    List<HU12DTO> hu12DTO(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //Como organizador quiero ver mi historial de Pagos descendientemente por su fecha por un ID evento
    @Query("SELECT NEW com.upc.ep.DTO.HU13DTO(p.idP, p.fechaPago, p.monto, p.estadoPago, p.contrato.evento.idE) " +
            "FROM Pago p " +
            "WHERE p.contrato.evento.idE = :idEvento " +
            "ORDER BY p.fechaPago DESC")
    List<HU13DTO> hu13DTO(@Param("idEvento") Long idEvento);

    //Como organizador quiero ver el monto total de todos los pagos realizados = true de un ID contrato
    @Query("SELECT NEW com.upc.ep.DTO.HU14DTO(p.contrato.idCo, SUM(p.monto)) " +
            "FROM Pago p " +
            "WHERE p.contrato.idCo = :idContrato AND p.estadoPago = true " +
            "GROUP BY p.contrato.idCo")
    List<HU14DTO> hu14DTO(@Param("idContrato") Long idContrato);

    //Como organizador quiero ver la cantidad de contratos por artista ordenados descendetemente
    @Query("SELECT NEW com.upc.ep.DTO.HU15DTO(ac.artista.idA, ac.artista.nombreArtista, COUNT(ac.contrato.idCo)) " +
            "FROM AC ac " +
            "GROUP BY ac.artista.idA, ac.artista.nombreArtista " +
            "ORDER BY COUNT(ac.contrato.idCo) DESC")
    List<HU15DTO> hu15DTO();
}
