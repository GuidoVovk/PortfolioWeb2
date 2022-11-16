
package com.portfolioWeb.Guido.security.repository;

import com.portfolioWeb.Guido.security.entity.Rol;
import com.portfolioWeb.Guido.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre); 
}
