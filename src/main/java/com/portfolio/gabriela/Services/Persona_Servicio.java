package com.portfolio.gabriela.Services;

import com.portfolio.gabriela.Models.Persona;
import com.portfolio.gabriela.Repositorios_JPA.iPersona_Repositorio_JPA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Persona_Servicio {
    
    @Autowired
    public iPersona_Repositorio_JPA persoRepoJPA;

    public List<Persona> getPersona() {
        return persoRepoJPA.findAll( );
    }
    public Persona getPersona(int id) {
        return persoRepoJPA.findById(id).orElse(null);
    }
   
    public void  savePersona(Persona persona){
        persoRepoJPA.save(persona);
    }

    public Persona findPersona(int id){
        return persoRepoJPA.findById(id).orElse(null);
    }

}
