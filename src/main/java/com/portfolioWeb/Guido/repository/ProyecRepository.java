
package com.portfolioWeb.Guido.repository;

import com.portfolioWeb.Guido.entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyecRepository extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findByNombreProyecto(String nombreProyecto);
    public boolean existsByNombreProyecto(String nombreProyecto);
}
