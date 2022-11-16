
package com.portfolioWeb.Guido.repository;

import com.portfolioWeb.Guido.entity.HabilidadesDesign;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabDesignRepository extends JpaRepository<HabilidadesDesign, Integer> {
    public Optional <HabilidadesDesign> findByNombreHabDesign(String nombreHabDesign);
    public boolean existsByNombreHabDesign (String nombreHabDesign);
}
