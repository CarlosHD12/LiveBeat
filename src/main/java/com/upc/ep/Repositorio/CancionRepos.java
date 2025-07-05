package com.upc.ep.Repositorio;
import com.upc.ep.Entidad.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CancionRepos extends JpaRepository<Cancion, Long> {
}
