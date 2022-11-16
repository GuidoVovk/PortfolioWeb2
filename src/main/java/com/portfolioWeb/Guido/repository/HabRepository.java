
package com.portfolioWeb.Guido.repository;

import com.portfolioWeb.Guido.entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabRepository extends JpaRepository<Habilidades, Integer> {
    public Optional <Habilidades> findByNombreHab(String nombreHab);
    public boolean existsByNombreHab (String nombreHab);
}
