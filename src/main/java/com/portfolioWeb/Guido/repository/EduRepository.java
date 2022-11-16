
package com.portfolioWeb.Guido.repository;

import com.portfolioWeb.Guido.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduRepository extends JpaRepository<Educacion, Integer>{
    public Optional <Educacion> findByNombreEdu(String nombreEdu);
    public boolean existsByNombreEdu(String nombreEdu);
}
