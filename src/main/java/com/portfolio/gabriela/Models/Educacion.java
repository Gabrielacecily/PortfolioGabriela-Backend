
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
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String lugar;
    private String logourl;
    private String url;
    private String fecha;
    private String titulo;
    private String descripcion;
    private boolean esCurso;
}

  

