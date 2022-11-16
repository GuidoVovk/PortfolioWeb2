
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.HabSoftDto;
import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.entity.HabilidadesSoft;
import com.portfolioWeb.Guido.service.HabSoftService;
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
@RequestMapping("/skillsSoft")
@CrossOrigin(origins = "http://localhost:4200")
public class HabSoftController {
    
    @Autowired
    HabSoftService habSoftService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesSoft>> list() {
        List<HabilidadesSoft> list = habSoftService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesSoft> getById(@PathVariable("id")int id){
        if(!habSoftService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesSoft habS = habSoftService.getOne(id).get();
        return new ResponseEntity(habS, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!habSoftService.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
      }
      habSoftService.delete(id);
      return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabSoftDto habDto){
        if (StringUtils.isBlank(habDto.getNombreHabSoft())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (habSoftService.existsByNombreHabSoft(habDto.getNombreHabSoft())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesSoft habS = new HabilidadesSoft(habDto.getNombreHabSoft(), habDto.getPorcentajeHabSoft());
        habSoftService.save(habS);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabSoftDto habDto){
        if(!habSoftService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.NOT_FOUND);
        }
        if(habSoftService.existsByNombreHabSoft(habDto.getNombreHabSoft()) && habSoftService.getByNombreHabSoft(habDto.getNombreHabSoft()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(habDto.getNombreHabSoft())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesSoft habS = habSoftService.getOne(id).get();
        
        habS.setNombreHabSoft(habDto.getNombreHabSoft());
        habS.setPorcentajeHabSoft(habDto.getPorcentajeHabSoft());
        
        habSoftService.save(habS);
        
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
}
