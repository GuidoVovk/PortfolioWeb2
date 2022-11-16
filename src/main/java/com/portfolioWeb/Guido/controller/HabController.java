
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.HabDto;
import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.entity.Habilidades;
import com.portfolioWeb.Guido.service.HabService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class HabController {
    
    @Autowired
    HabService habService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = habService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id")int id){
        if(!habService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidades hab = habService.getOne(id).get();
        return new ResponseEntity(hab, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!habService.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
      }
      habService.delete(id);
      return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabDto habDto){
        if (StringUtils.isBlank(habDto.getNombreHab())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (habService.existsByNombreHab(habDto.getNombreHab())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        Habilidades hab = new Habilidades(habDto.getNombreHab(), habDto.getPorcentajeHab());
        habService.save(hab);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabDto habDto){
        if(!habService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.NOT_FOUND);
        }
        if(habService.existsByNombreHab(habDto.getNombreHab()) && habService.getByNombreHab(habDto.getNombreHab()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(habDto.getNombreHab())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidades hab = habService.getOne(id).get();
        
        hab.setNombreHab(habDto.getNombreHab());
        hab.setPorcentajeHab(habDto.getPorcentajeHab());
        
        habService.save(hab);
        
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}
