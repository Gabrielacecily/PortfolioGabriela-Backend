package com.portfolio.gabriela.Controllers;

import com.portfolio.gabriela.DTO.ExperienciaDTO;
import com.portfolio.gabriela.Models.Experiencia;
import com.portfolio.gabriela.Services.Experiencia_Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencias")
@CrossOrigin(origins = "*")
public class Controlador_Experiencias {
    
    @Autowired 
    private Experiencia_Servicio experiencia_Servicio;
     
    @GetMapping("/getExp")
    public ResponseEntity< List<Experiencia> > getExperiencias(){
        return new ResponseEntity( experiencia_Servicio.getExperiencias(), HttpStatus.OK);
    }
    
   @PutMapping("/updateExp/{id}")
    public ResponseEntity<?> editarExperiencia( @PathVariable("id")int id, @RequestBody ExperienciaDTO experienciaDTO){
        Experiencia experienciaAEditar = experiencia_Servicio.findExp(id);
              experienciaAEditar.setLugar(experienciaDTO.getLugar() );
              experienciaAEditar.setUrl(experienciaDTO.getUrl() );
              experienciaAEditar.setFecha(experienciaDTO.getFecha() );
              experienciaAEditar.setPuesto(experienciaDTO.getPuesto() );
              experienciaAEditar.setDescripcion(experienciaDTO.getDescripcion() );
      experiencia_Servicio.saveExp(experienciaAEditar);
     return new ResponseEntity(  HttpStatus.CREATED);
    }

      @DeleteMapping("/deleteExp/{id}")
    public ResponseEntity<?> borrarExp( @PathVariable("id")int id ){
        experiencia_Servicio.delete(id);
        return new ResponseEntity(  HttpStatus.OK);
    }
    
    
}

