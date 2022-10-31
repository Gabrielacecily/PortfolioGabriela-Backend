package com.portfolio.gabriela.Security.RepositoryJPA;

import com.portfolio.gabriela.Security.Entity.Rol;
import com.portfolio.gabriela.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface iRolRepository_JPA extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
