
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.HabDesignDto;
import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.entity.HabilidadesDesign;
import com.portfolioWeb.Guido.service.HabDesignService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skillsDesign")
@CrossOrigin(origins = "http://localhost:4200")
public class HabDesignController {
    
    @Autowired
    HabDesignService habDesignService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesDesign>> list() {
        List<HabilidadesDesign> list = habDesignService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesDesign> getById(@PathVariable("id")int id){
        if(!habDesignService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesDesign habD = habDesignService.getOne(id).get();
        return new ResponseEntity(habD, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!habDesignService.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
      }
      habDesignService.delete(id);
      return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabDesignDto habDesignDto){
        if (StringUtils.isBlank(habDesignDto.getNombreHabDesign())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (habDesignService.existsByNombreHabDesign(habDesignDto.getNombreHabDesign())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesDesign habD = new HabilidadesDesign(habDesignDto.getNombreHabDesign(), habDesignDto.getPorcentajeHabDesign());
        habDesignService.save(habD);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabDesignDto habDesignDto){
        if(!habDesignService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.NOT_FOUND);
        }
        if(habDesignService.existsByNombreHabDesign(habDesignDto.getNombreHabDesign()) && habDesignService.getByNombreHabDesign(habDesignDto.getNombreHabDesign()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(habDesignDto.getNombreHabDesign())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesDesign habD = habDesignService.getOne(id).get();
        
        habD.setNombreHabDesign(habDesignDto.getNombreHabDesign());
        habD.setPorcentajeHabDesign(habDesignDto.getPorcentajeHabDesign());
        
        habDesignService.save(habD);
        
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}
