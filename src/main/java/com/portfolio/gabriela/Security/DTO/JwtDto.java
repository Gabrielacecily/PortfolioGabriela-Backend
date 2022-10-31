package com.portfolio.gabriela.Security.DTO;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import lombok.AllArgsConstructor; 
import lombok.Getter; import lombok.Setter;

@AllArgsConstructor
@Getter @Setter 
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    //constructor sin el bearer
    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }


}
