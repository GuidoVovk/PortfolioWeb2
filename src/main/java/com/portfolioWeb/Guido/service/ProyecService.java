
package com.portfolioWeb.Guido.service;

import com.portfolioWeb.Guido.entity.Proyectos;
import com.portfolioWeb.Guido.repository.ProyecRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyecService {
    
    @Autowired
    ProyecRepository proyecRepository;
    
    public List<Proyectos> list(){
        return proyecRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return proyecRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto){
        return proyecRepository.findByNombreProyecto(nombreProyecto);
    }
    
    public void save(Proyectos proyectos){
        proyecRepository.save(proyectos);
    }
    
    public void delete(int id){
        proyecRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyecRepository.existsById(id);
    }
    
    public boolean existsByNombreProyecto(String nombreProyecto){
        return proyecRepository.existsByNombreProyecto(nombreProyecto);
    }
}
