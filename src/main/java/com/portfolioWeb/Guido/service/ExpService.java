
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.Experiencia;
import com.portfolioWeb.Guido.repository.ExpRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExpService {
    
   @Autowired
   ExpRepository expRepository;
   
   public List<Experiencia> list(){
        return expRepository.findAll();
    }
   
   public Optional<Experiencia> getOne(int id){
        return expRepository.findById(id);
    }
   
   public Optional<Experiencia> getByNombreExp(String nombreExp){
        return expRepository.findByNombreExp(nombreExp);
    }
   
    public void save(Experiencia expe){
        expRepository.save(expe);
    }
    
    public void delete(int id){
        expRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return expRepository.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return expRepository.existsByNombreExp(nombreExp);
    }
    
}
