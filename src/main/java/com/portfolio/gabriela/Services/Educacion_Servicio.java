
package com.portfolio.gabriela.Services;

import com.portfolio.gabriela.Models.Educacion;
import com.portfolio.gabriela.Repositorios_JPA.iEducacion_Repositorio_JPA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Educacion_Servicio {
    @Autowired
    public iEducacion_Repositorio_JPA educRepoJPA;
    
    public List<Educacion> getEducacion(){
        return educRepoJPA.findAll();
    }  
        
    public void saveEducacion(Educacion educAEditar){
        educRepoJPA.save(educAEditar);
    }

    public Educacion findEduc(int id){
        return educRepoJPA.findById(id).orElse(null);
    }
    
    public void delete(int id){
        educRepoJPA.deleteById(id);
    }
    
}