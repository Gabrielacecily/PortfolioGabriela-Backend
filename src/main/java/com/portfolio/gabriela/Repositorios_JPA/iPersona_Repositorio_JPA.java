
package com.portfolio.gabriela.Repositorios_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.portfolio.gabriela.Models.Persona;

@Repository
public interface iPersona_Repositorio_JPA extends JpaRepository<Persona, Integer>{
    
}
