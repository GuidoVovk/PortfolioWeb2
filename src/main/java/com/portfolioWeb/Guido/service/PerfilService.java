
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.Perfil;
import com.portfolioWeb.Guido.repository.PerfilRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PerfilService {
    
    @Autowired
    PerfilRepository perfilRepository;
    
    public List<Perfil> list(){
        return perfilRepository.findAll();
    }
    
    public Optional<Perfil> getOne(int id){
        return perfilRepository.findById(id);
    }
    
    public Optional<Perfil> getByNombrePerfil(String nombrePerfil){
        return perfilRepository.findByNombrePerfil(nombrePerfil);
    }
    
    public void save(Perfil per){
        perfilRepository.save(per);
    }
    
    public void delete(int id){
        perfilRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return perfilRepository.existsById(id);
    }
    
    public boolean existsByNombrePerfil(String nombrePerfil){
        return perfilRepository.existsByNombrePerfil(nombrePerfil);
    }
}
