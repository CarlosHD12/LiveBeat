package com.upc.ep.Repositorio;

import com.upc.ep.Entidad.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepos  extends JpaRepository<Calificacion, Long> {
}
