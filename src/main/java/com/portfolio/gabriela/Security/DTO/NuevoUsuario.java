package com.portfolio.gabriela.Security.DTO;


import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
public class NuevoUsuario {

    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();


}
