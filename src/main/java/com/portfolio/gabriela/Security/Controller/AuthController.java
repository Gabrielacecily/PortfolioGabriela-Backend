package com.portfolio.gabriela.Security.Controller;

import com.portfolio.gabriela.Security.DTO.JwtDto;
import com.portfolio.gabriela.Security.DTO.LoginUsuario;
import com.portfolio.gabriela.Security.DTO.NuevoUsuario;
import com.portfolio.gabriela.Security.Entity.Rol;
import com.portfolio.gabriela.Security.Entity.Usuario;
import com.portfolio.gabriela.Security.Enums.RolNombre;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.gabriela.Security.JWT.JwtProvider;
import com.portfolio.gabriela.Security.Services.RolService;
import com.portfolio.gabriela.Security.Services.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

        @Autowired
        PasswordEncoder passwordEncoder;
        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        UsuarioService usuarioService;
        @Autowired
        RolService rolService;
        @Autowired
        JwtProvider jwtProvider;

        @PostMapping("/login")
        public JwtDto login(@Valid @RequestBody LoginUsuario loginUsuario) {
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);

                String token = jwtProvider.generateToken(authentication);// genera el token con UserName + algoritmo de encriptacion + tiempo de expiracion
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                JwtDto jwtDto = new JwtDto(token, userDetails.getUsername(), userDetails.getAuthorities());// objeto con el token + username + authoritie

                return jwtDto;
        }

        
          @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario){
        
        Usuario usuario = new Usuario( nuevoUsuario.getNombreUsuario(), passwordEncoder.encode(nuevoUsuario.getPassword()));

       Set<Rol> roles = new HashSet<>();
        roles.add( rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get() );
        usuario.setRoles(roles);
        
        usuarioService.save(usuario);
        
        return new ResponseEntity( "Nuevo usuario creado", HttpStatus.CREATED);
    }
    
}
