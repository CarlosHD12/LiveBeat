package com.upc.ep.Repositorio;
import com.upc.ep.Entidad.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepos extends JpaRepository<Cancion, Long> {
}
