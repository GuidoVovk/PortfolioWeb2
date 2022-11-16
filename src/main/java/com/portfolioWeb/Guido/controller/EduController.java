
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.EduDto;
import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.entity.Educacion;
import com.portfolioWeb.Guido.service.EduService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EduController {
    
    @Autowired
    EduService eduService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
       List<Educacion> list = eduService.list();
       return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!eduService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = eduService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!eduService.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
      }
      eduService.delete(id);
      return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EduDto eduDto){
        if (StringUtils.isBlank(eduDto.getNombreEdu())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (eduService.existsByNombreEdu(eduDto.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(eduDto.getDescripcionEdu())){
            return new ResponseEntity(new Mensaje("Descripcion obligatoria"),HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(eduDto.getFechaEdu())){
            return new ResponseEntity(new Mensaje("Fecha obligatoria"),HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(eduDto.getNombreEdu(), eduDto.getTituloEdu(), eduDto.getDescripcionEdu(), eduDto.getFechaEdu());
        eduService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EduDto eduDto){
        if(!eduService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.NOT_FOUND);
        }
        if(eduService.existsByNombreEdu(eduDto.getNombreEdu()) && eduService.getByNombreEdu(eduDto.getNombreEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(eduDto.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(eduDto.getDescripcionEdu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(eduDto.getFechaEdu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        
        
        Educacion educacion = eduService.getOne(id).get();
        
        educacion.setNombreEdu(eduDto.getNombreEdu());
        educacion.setTituloEdu(eduDto.getTituloEdu());
        educacion.setDescripcionEdu(eduDto.getDescripcionEdu());
        educacion.setFechaEdu(eduDto.getFechaEdu());
        
        eduService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
