package com.upc.ep.Repositorio;

import com.upc.ep.Entidad.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepos  extends JpaRepository<Pago, Long> {
}
