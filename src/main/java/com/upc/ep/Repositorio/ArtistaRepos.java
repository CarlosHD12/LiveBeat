package com.upc.ep.Repositorio;
import com.upc.ep.DTO.*;
import com.upc.ep.Entidad.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistaRepos extends JpaRepository<Artista, Long> {

    //Como Artista quiero ver los eventos en los que estoy contratado
    @Query("SELECT NEW com.upc.ep.DTO.HU22DTO(h.artista.idA,h.contrato.evento.nombreEvento,h.contrato.fechaContrato,h.contrato.montoTotal) " +
            "FROM AC h " +
            "WHERE h.artista.idA = :idArtista " +
            "ORDER BY h.contrato.montoTotal, h.contrato.fechaContrato,h.contrato.evento.nombreEvento")
    List<HU22DTO> hu22DTO(@Param("idArtista") Long idArtista);

    //Como Artista quiero ver mis canciones ordenadas de mayor a menor por su duracion y
    @Query("SELECT NEW com.upc.ep.DTO.HU23DTO(c.artista.nombreArtista, c.titulo, c.duracion) " +
            "FROM Cancion c " +
            "WHERE c.artista.idA = :idArtista " +
            "ORDER BY c.duracion DESC, c.titulo")
    List<HU23DTO> hu23DTO(@Param("idArtista") Long idArtista);

    //Como Artista quiero ver todas mis calificaciones
    @Query("SELECT NEW com.upc.ep.DTO.HU24DTO(ca.artista.idA, ca.organizador.nombreOrganizador, ca.comentario, ca.valoracion) " +
            "FROM Calificacion ca " +
            "WHERE ca.artista.idA = :idArtista")
    List<HU24DTO> hu24DTO(@Param("idArtista") Long idArtista);

    //Como Artista quiero ver los eventos para poder registrarme
    @Query("SELECT NEW com.upc.ep.DTO.HU25DTO(e.nombreEvento, e.organizador.direccion, e.fecha, e.tipoEvento) " +
            "FROM Evento e " +
            "ORDER BY e.nombreEvento, e.organizador.direccion, e.fecha, e.tipoEvento")
    List<HU25DTO> hu25DTO();

    //Como Artista quiero ver el total que me han pagado en todos mis contratos con estado = true
    @Query("SELECT NEW com.upc.ep.DTO.HU26DTO(ac.artista.idA, SUM(p.monto)) " +
            "FROM AC ac " +
            "JOIN Pago p ON p.contrato.idCo = ac.contrato.idCo " +
            "WHERE ac.artista.idA = :idArtista AND p.estadoPago = true " +
            "GROUP BY ac.artista.idA")
    List<HU26DTO> hu26DTO(@Param("idArtista") Long idArtista);
}
