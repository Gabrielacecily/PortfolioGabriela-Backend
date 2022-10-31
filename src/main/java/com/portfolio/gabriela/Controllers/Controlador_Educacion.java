package com.portfolio.gabriela.Controllers;

import com.portfolio.gabriela.DTO.EducacionDTO;
import com.portfolio.gabriela.Models.Educacion;
import com.portfolio.gabriela.Services.Educacion_Servicio;

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
@RequestMapping("/educacion")
@CrossOrigin(origins = "*")
public class Controlador_Educacion {
       @Autowired 
    private Educacion_Servicio educacion_Servicio;
     
    @GetMapping("/getEduc")
    public ResponseEntity< List<Educacion> > getEducacion(){
        return new ResponseEntity( educacion_Servicio.getEducacion(), HttpStatus.OK);
    }
    
   @PutMapping("/updateEduc/{id}")
    public ResponseEntity<?> updateEducacion( @PathVariable("id")int id, @RequestBody EducacionDTO educacionDTO){
        Educacion educacionAEditar = educacion_Servicio.findEduc(id);
              educacionAEditar.setLugar( educacionDTO.getLugar() );
              educacionAEditar.setLogourl( educacionDTO.getLogourl() );
              educacionAEditar.setUrl( educacionDTO.getUrl() );
              educacionAEditar.setFecha( educacionDTO.getFecha() );
              educacionAEditar.setTitulo( educacionDTO.getTitulo() );
              educacionAEditar.setDescripcion( educacionDTO.getDescripcion() );
      educacion_Servicio.saveEducacion( educacionAEditar );
     return new ResponseEntity( HttpStatus.CREATED);
    }
    
    @DeleteMapping("/deleteEduc/{id}")
    public ResponseEntity<?> deleteEducacion( @PathVariable("id")int id ){
        educacion_Servicio.delete(id);
        return new ResponseEntity(  HttpStatus.OK);
    }

}
