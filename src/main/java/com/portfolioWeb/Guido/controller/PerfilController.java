
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.dto.PerfilDto;
import com.portfolioWeb.Guido.entity.Perfil;
import com.portfolioWeb.Guido.service.PerfilService;
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
@RequestMapping("/perfil")
@CrossOrigin(origins = "https://portfolioguido.web.app")
public class PerfilController {
    
    @Autowired
    PerfilService perfilService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Perfil>> list(){
       List<Perfil> list = perfilService.list();
       return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PerfilDto perfilDto){
        if(StringUtils.isBlank(perfilDto.getNombrePerfil()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(perfilService.existsByNombrePerfil(perfilDto.getNombrePerfil()))
            return new ResponseEntity(new Mensaje("Perfil no existe"), HttpStatus.BAD_REQUEST);
        Perfil perfil = new Perfil(perfilDto.getNombrePerfil(), perfilDto.getNombrePuesto(), perfilDto.getDescPerfil(), perfilDto.getImgPerfil());
        perfilService.save(perfil);
            
        return new ResponseEntity (new Mensaje("Perfil agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody PerfilDto perfilDto){
        if(!perfilService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(perfilService.existsByNombrePerfil(perfilDto.getNombrePerfil()) && perfilService.getByNombrePerfil(perfilDto.getNombrePerfil()).get().getId() != id)
            return new ResponseEntity(new Mensaje ("El perfil ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(perfilDto.getNombrePerfil()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Perfil perfil = perfilService.getOne(id).get();
        perfil.setNombrePerfil(perfilDto.getNombrePerfil());
        perfil.setNombrePuesto(perfilDto.getNombrePuesto());
        perfil.setDescPerfil(perfilDto.getDescPerfil());
        perfil.setImgPerfil(perfilDto.getImgPerfil());
        
        perfilService.save(perfil);
        return new ResponseEntity(new Mensaje("Perfil actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!perfilService.existsById(id))
            return new ResponseEntity (new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        
        perfilService.delete(id);
        
        return new ResponseEntity (new Mensaje ("Perfil eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable("id") int id){
        if(!perfilService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Perfil perfil = perfilService.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }
    
    
}
