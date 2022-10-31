
package com.portfolio.gabriela.Security.Services;

import com.portfolio.gabriela.Security.Entity.Rol;
import com.portfolio.gabriela.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.portfolio.gabriela.Security.RepositoryJPA.iRolRepository_JPA;

@Service
@Transactional
public class RolService {

    @Autowired
    iRolRepository_JPA rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
