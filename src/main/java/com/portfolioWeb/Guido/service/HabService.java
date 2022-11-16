
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.Habilidades;
import com.portfolioWeb.Guido.repository.HabRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabService {
    
    @Autowired
    HabRepository habRepository;
    
    public List<Habilidades> list(){
        return habRepository.findAll();
    }
    
    public Optional<Habilidades> getOne(int id){
        return habRepository.findById(id);
    }
    
    public Optional<Habilidades> getByNombreHab(String nombreHab){
        return habRepository.findByNombreHab(nombreHab);
    }
    
    public void save(Habilidades hab){
        habRepository.save(hab);
    }
    
    public void delete(int id){
        habRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return habRepository.existsById(id);
    }
    
    public boolean existsByNombreHab(String nombreHab){
        return habRepository.existsByNombreHab(nombreHab);
    }
}
