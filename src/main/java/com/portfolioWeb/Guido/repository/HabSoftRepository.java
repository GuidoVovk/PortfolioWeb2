
package com.portfolioWeb.Guido.repository;

import com.portfolioWeb.Guido.entity.HabilidadesSoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabSoftRepository extends JpaRepository<HabilidadesSoft, Integer> {
    public Optional <HabilidadesSoft> findByNombreHabSoft(String nombreHabSoft);
    public boolean existsByNombreHabSoft (String nombreHabSoft);
}
