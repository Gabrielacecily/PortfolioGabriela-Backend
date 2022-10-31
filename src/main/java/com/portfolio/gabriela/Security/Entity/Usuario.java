package com.portfolio.gabriela.Security.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import lombok.NoArgsConstructor; import lombok.RequiredArgsConstructor;
import lombok.Getter; import lombok.Setter;
import lombok.NonNull;

@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter 
@Entity
public class Usuario {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)  private int id;
    
    @NonNull @NotNull  @Column(unique = true)
    private String nombreUsuario;

    @NonNull @NotNull
    private String password;
    
    @NotNull  @ManyToMany(fetch = FetchType.EAGER)  
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id") )
    private Set<Rol> roles = new HashSet<>();

}
