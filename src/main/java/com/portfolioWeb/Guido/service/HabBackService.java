
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.HabilidadesBack;
import com.portfolioWeb.Guido.repository.HabBackRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabBackService {
    
    @Autowired
    HabBackRepository habBackRepository;
    
    public List<HabilidadesBack> list(){
        return habBackRepository.findAll();
    }
    
    public Optional<HabilidadesBack> getOne(int id){
        return habBackRepository.findById(id);
    }
    
    public Optional<HabilidadesBack> getByNombreHabBack(String nombreHabBack){
        return habBackRepository.findByNombreHabBack(nombreHabBack);
    }
    
    public void save(HabilidadesBack habB){
        habBackRepository.save(habB);
    }
    
    public void delete(int id){
        habBackRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return habBackRepository.existsById(id);
    }
    
    public boolean existsByNombreHabBack(String nombreHabBack){
        return habBackRepository.existsByNombreHabBack(nombreHabBack);
    }
}
