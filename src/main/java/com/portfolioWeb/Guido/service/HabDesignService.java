
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.HabilidadesDesign;
import com.portfolioWeb.Guido.repository.HabDesignRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabDesignService {
    
    @Autowired
    HabDesignRepository habDesignRepository;
    
    public List<HabilidadesDesign> list(){
        return habDesignRepository.findAll();
    }
    
    public Optional<HabilidadesDesign> getOne(int id){
        return habDesignRepository.findById(id);
    }
    
    public Optional<HabilidadesDesign> getByNombreHabDesign(String nombreHabDesign){
        return habDesignRepository.findByNombreHabDesign(nombreHabDesign);
    }
    
    public void save(HabilidadesDesign habD){
        habDesignRepository.save(habD);
    }
    
    public void delete(int id){
        habDesignRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return habDesignRepository.existsById(id);
    }
    
    public boolean existsByNombreHabDesign(String nombreHabDesign){
        return habDesignRepository.existsByNombreHabDesign(nombreHabDesign);
    }
}
