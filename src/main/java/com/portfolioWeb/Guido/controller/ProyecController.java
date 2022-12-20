
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.dto.ProyecDto;
import com.portfolioWeb.Guido.entity.Proyectos;
import com.portfolioWeb.Guido.service.ProyecService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://portfolioguido.web.app")
public class ProyecController {
    
    @Autowired
    ProyecService proyecService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyecService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!proyecService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = proyecService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!proyecService.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
      }
      proyecService.delete(id);
      return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyecDto proyecDto){
        if (StringUtils.isBlank(proyecDto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (proyecService.existsByNombreProyecto(proyecDto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(proyecDto.getDescProyecto())){
            return new ResponseEntity(new Mensaje("Descripción obligatoria"),HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = new Proyectos(proyecDto.getNombreProyecto(), proyecDto.getDescProyecto(), proyecDto.getImgProyecto(), proyecDto.getEnlaceProyecto());
        proyecService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyecDto proyecDto){
        if(!proyecService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.NOT_FOUND);
        }
        if(proyecService.existsByNombreProyecto(proyecDto.getNombreProyecto()) && proyecService.getByNombreProyecto(proyecDto.getNombreProyecto()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proyecDto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(proyecDto.getDescProyecto())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = proyecService.getOne(id).get();
        
        proyectos.setNombreProyecto(proyecDto.getNombreProyecto());
        proyectos.setDescProyecto(proyecDto.getDescProyecto());
        proyectos.setImgProyecto(proyecDto.getImgProyecto());
        proyectos.setEnlaceProyecto(proyecDto.getEnlaceProyecto());
        
        proyecService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
