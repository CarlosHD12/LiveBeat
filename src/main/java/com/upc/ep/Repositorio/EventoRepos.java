package com.upc.ep.Repositorio;
import com.upc.ep.Entidad.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepos extends JpaRepository<Evento, Long> {
}
