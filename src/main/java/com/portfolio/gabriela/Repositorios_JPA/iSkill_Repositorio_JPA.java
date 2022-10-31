
package com.portfolio.gabriela.Repositorios_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.portfolio.gabriela.Models.Skill;

@Repository
public interface iSkill_Repositorio_JPA extends JpaRepository<Skill, Integer>{
    
}
