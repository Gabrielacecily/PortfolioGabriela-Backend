package com.portfolio.gabriela.Controllers;


import com.portfolio.gabriela.DTO.PersonaDTO;
import com.portfolio.gabriela.Models.Persona;
import com.portfolio.gabriela.Services.Persona_Servicio;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class Controlador_Persona {

    @Autowired 
    private Persona_Servicio persona_Servicio;

    @GetMapping("/getPers")
    public ResponseEntity< List<Persona> > getPersona( ){
        return new ResponseEntity( persona_Servicio.getPersona(), HttpStatus.OK);
    }
    
    @PutMapping("/updatePers/{id}")
    public ResponseEntity<?> editarPersona( @PathVariable("id")int id, @RequestBody PersonaDTO personaDTO){
      Persona personaAEditar = persona_Servicio.findPersona(id);
                personaAEditar.setComentario( personaDTO.getComentario() );
                //personaAEditar.setEdad( personaDTO.getEdad() );
                personaAEditar.setTelefono( personaDTO.getTelefono() );
                personaAEditar.setCiudad( personaDTO.getCiudad() );
                personaAEditar.setWeb( personaDTO.getWeb() );
                personaAEditar.setEmail( personaDTO.getEmail() );
                personaAEditar.setTitulo( personaDTO.getTitulo() );
      persona_Servicio.savePersona(personaAEditar);
     return new ResponseEntity(  HttpStatus.CREATED);
    }

    
}