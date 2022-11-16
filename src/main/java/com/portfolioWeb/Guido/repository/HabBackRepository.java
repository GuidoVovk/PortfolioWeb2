
package com.portfolioWeb.Guido.repository;

import com.portfolioWeb.Guido.entity.HabilidadesBack;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabBackRepository extends JpaRepository<HabilidadesBack, Integer> {
    public Optional <HabilidadesBack> findByNombreHabBack(String nombreHabBack);
    public boolean existsByNombreHabBack (String nombreHabBack);
}
