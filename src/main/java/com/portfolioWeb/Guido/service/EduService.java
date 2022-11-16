
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.Educacion;
import com.portfolioWeb.Guido.repository.EduRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EduService {
    
    @Autowired
    EduRepository eduRepository;
    
    public List<Educacion> list(){
        return eduRepository.findAll();
    }
    
     public Optional<Educacion> getOne(int id){
         return eduRepository.findById(id);
     }
     
     public Optional<Educacion> getByNombreEdu(String nombreEdu){
         return eduRepository.findByNombreEdu(nombreEdu);
     }
     
     public void save(Educacion educacion){
         eduRepository.save(educacion);
     }
     
     public void delete(int id){
        eduRepository.deleteById(id);
    }
     
    public boolean existsById(int id){
        return eduRepository.existsById(id);
    }
    
    public boolean existsByNombreEdu(String nombreEdu){
        return eduRepository.existsByNombreEdu(nombreEdu);
    }
}
