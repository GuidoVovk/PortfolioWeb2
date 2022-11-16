
package com.portfolioWeb.Guido.repository;

import com.portfolioWeb.Guido.entity.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    public Optional<Perfil> findByNombrePerfil (String nombrePerfil);
    public boolean existsByNombrePerfil (String nombrePerfil);
}
