package com.portfolio.gabriela.Models;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    private String nombre;
    private String apellido;
    private String comentario;
    //private int edad;
    private String telefono;
    private String ciudad;
    private String web;
    private String email;
    private String titulo;
}
