
package com.portfolioWeb.Guido.security.service;

import com.portfolioWeb.Guido.security.entity.Rol;
import com.portfolioWeb.Guido.security.enums.RolNombre;
import com.portfolioWeb.Guido.security.repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
