
package com.portfolio.gabriela.Services;

import com.portfolio.gabriela.Models.Skill;
import com.portfolio.gabriela.Repositorios_JPA.iSkill_Repositorio_JPA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Skill_Servicio {

    @Autowired
    public iSkill_Repositorio_JPA skillRepoJPA;
    
    public List<Skill> getSkills(){
        return skillRepoJPA.findAll();
    }  
        
    public void  saveSkill(Skill skillEditar){
        skillRepoJPA.save(skillEditar);
    }

    public Skill findSkill(int id){
        return skillRepoJPA.findById(id).orElse(null);
    }
    
    public void delete(int id){
        skillRepoJPA.deleteById(id);
    }
}