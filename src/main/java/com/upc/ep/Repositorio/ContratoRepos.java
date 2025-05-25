package com.upc.ep.Repositorio;

import com.upc.ep.Entidad.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepos  extends JpaRepository<Contrato, Long> {
}
