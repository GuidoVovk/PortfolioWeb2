
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.HabilidadesSoft;
import com.portfolioWeb.Guido.repository.HabSoftRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabSoftService {
    
    @Autowired
    HabSoftRepository habSoftRepository;
    
    public List<HabilidadesSoft> list(){
        return habSoftRepository.findAll();
    }
    
    public Optional<HabilidadesSoft> getOne(int id){
        return habSoftRepository.findById(id);
    }
    
    public Optional<HabilidadesSoft> getByNombreHabSoft(String nombreHabSoft){
        return habSoftRepository.findByNombreHabSoft(nombreHabSoft);
    }
    
    public void save(HabilidadesSoft hab){
        habSoftRepository.save(hab);
    }
    
    public void delete(int id){
        habSoftRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return habSoftRepository.existsById(id);
    }
    
    public boolean existsByNombreHabSoft(String nombreHabSoft){
        return habSoftRepository.existsByNombreHabSoft(nombreHabSoft);
    }
}
