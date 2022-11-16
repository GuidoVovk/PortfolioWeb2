
package com.portfolioWeb.Guido.controller;

import com.portfolioWeb.Guido.dto.HabBackDto;
import com.portfolioWeb.Guido.dto.Mensaje;
import com.portfolioWeb.Guido.entity.HabilidadesBack;
import com.portfolioWeb.Guido.service.HabBackService;
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
@RequestMapping("/skillsBack")
@CrossOrigin(origins = "http://localhost:4200")
public class HabBackController {
    
    @Autowired
    HabBackService habBackService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesBack>> list() {
        List<HabilidadesBack> list = habBackService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesBack> getById(@PathVariable("id")int id){
        if(!habBackService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesBack habB = habBackService.getOne(id).get();
        return new ResponseEntity(habB, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
      if(!habBackService.existsById(id)){
          return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
      }
      habBackService.delete(id);
      return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HabBackDto habBackDto){
        if (StringUtils.isBlank(habBackDto.getNombreHabBack())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (habBackService.existsByNombreHabBack(habBackDto.getNombreHabBack())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesBack habB = new HabilidadesBack(habBackDto.getNombreHabBack(), habBackDto.getPorcentajeHabBack());
        habBackService.save(habB);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabBackDto habBackDto){
        if(!habBackService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id no existe"), HttpStatus.NOT_FOUND);
        }
        if(habBackService.existsByNombreHabBack(habBackDto.getNombreHabBack()) && habBackService.getByNombreHabBack(habBackDto.getNombreHabBack()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(habBackDto.getNombreHabBack())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        HabilidadesBack habB = habBackService.getOne(id).get();
        
        habB.setNombreHabBack(habBackDto.getNombreHabBack());
        habB.setPorcentajeHabBack(habBackDto.getPorcentajeHabBack());
        
        habBackService.save(habB);
        
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
}
