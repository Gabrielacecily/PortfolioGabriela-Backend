package com.portfolio.gabriela.Controllers;

import com.portfolio.gabriela.DTO.SkillDTO;
import com.portfolio.gabriela.Models.Skill;
import com.portfolio.gabriela.Services.Skill_Servicio;

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
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
public class Controlador_Skills {
    
        @Autowired 
    private Skill_Servicio skill_Servicio;
     
    @GetMapping("/getSkills")
    public ResponseEntity< List<Skill> > getSkills(){
        return new ResponseEntity( skill_Servicio.getSkills(), HttpStatus.OK);
    }
    
   @PutMapping("/updateSkill/{id}")
    public ResponseEntity<?> editarSkill( @PathVariable("id")int id, @RequestBody SkillDTO SkillDTO){
        Skill skillAEditar = skill_Servicio.findSkill(id);
              skillAEditar.setNombreSkill(SkillDTO.getNombreSkill() );
              skillAEditar.setNivel(SkillDTO.getNivel());
      skill_Servicio.saveSkill(skillAEditar);
     return new ResponseEntity(  HttpStatus.CREATED);
    }

 @DeleteMapping("/deleteSkill/{id}")
    public ResponseEntity<?> borrarSkill( @PathVariable("id")int id ){
        skill_Servicio.delete(id);
        return new ResponseEntity(  HttpStatus.OK);
    }
}
