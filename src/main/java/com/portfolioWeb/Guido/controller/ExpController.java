
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.ExpDto;
import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.entity.Experiencia;
import com.portfolioWeb.Guido.service.ExpService;
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
@RequestMapping("/explab")
@CrossOrigin
public class ExpController {
    
    @Autowired
    ExpService expService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
       List<Experiencia> list = expService.list();
       return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExpDto expDto){
        if(StringUtils.isBlank(expDto.getNombreExp()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expService.existsByNombreExp(expDto.getNombreExp()))
            return new ResponseEntity(new Mensaje("esa experiencia existe"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = new Experiencia(expDto.getNombreExp(), expDto.getNombreEmpresa(), expDto.getFechaExp(), expDto.getDescripcionExp());
        expService.save(experiencia);
            
        return new ResponseEntity (new Mensaje("experiencia agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody ExpDto expDto){
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        if(expService.existsByNombreExp(expDto.getNombreExp()) && expService.getByNombreExp(expDto.getNombreExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje ("esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(expDto.getNombreExp()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = expService.getOne(id).get();
        experiencia.setNombreExp(expDto.getNombreExp());
        experiencia.setNombreEmpresa(expDto.getNombreEmpresa());
        experiencia.setFechaExp(expDto.getFechaExp());
        experiencia.setDescripcionExp(expDto.getDescripcionExp());
        
        expService.save(experiencia);
        return new ResponseEntity(new Mensaje("expiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!expService.existsById(id))
            return new ResponseEntity (new Mensaje("el id no existe"), HttpStatus.NOT_FOUND);
        
        expService.delete(id);
        
        return new ResponseEntity (new Mensaje ("experiencia eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
