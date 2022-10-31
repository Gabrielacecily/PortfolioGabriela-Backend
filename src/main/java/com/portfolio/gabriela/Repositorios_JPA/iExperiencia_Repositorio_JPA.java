
package com.portfolio.gabriela.Repositorios_JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.gabriela.Models.Experiencia;

@Repository
public interface iExperiencia_Repositorio_JPA extends JpaRepository<Experiencia, Integer>{
    
}
