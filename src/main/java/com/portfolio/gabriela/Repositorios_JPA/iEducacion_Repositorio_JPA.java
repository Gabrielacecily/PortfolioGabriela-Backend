
package com.portfolio.gabriela.Repositorios_JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.gabriela.Models.Educacion;

@Repository
public interface iEducacion_Repositorio_JPA extends JpaRepository<Educacion, Integer>{
    
}
