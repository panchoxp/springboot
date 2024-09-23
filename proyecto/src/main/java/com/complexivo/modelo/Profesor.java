package com.complexivo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data//getters y setters
@Entity
@Table(name = "Tabla_profesor")
public class Profesor {
    //este codigo es usando serializable que lo vuelva mas robusto
    //serializar sirve para la persistencias de datos
    /*public class Profesor implements Serializable {
    private static final long serialVersionUID=1L;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesor;
    @Column(name = "nombreProfesor", length =50)//personalizar
    private String nombre_profesor;
    private String apellido_profesor;
    private String email;
    private String especializacion;
}
