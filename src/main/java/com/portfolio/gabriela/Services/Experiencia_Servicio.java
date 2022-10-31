package com.portfolio.gabriela.Services;

import com.portfolio.gabriela.Models.Experiencia;
import com.portfolio.gabriela.Repositorios_JPA.iExperiencia_Repositorio_JPA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Experiencia_Servicio {

    @Autowired
    public iExperiencia_Repositorio_JPA expRepoJPA;
    
    public List<Experiencia> getExperiencias(){
        return expRepoJPA.findAll();
    }  
        
    public void  saveExp(Experiencia expEditar){
        expRepoJPA.save(expEditar);
    }

    public Experiencia findExp(int id){
        return expRepoJPA.findById(id).orElse(null);
    }
    
     public void delete(int id){
        expRepoJPA.deleteById(id);
    }
}
