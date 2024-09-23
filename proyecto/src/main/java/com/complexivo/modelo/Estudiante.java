package com.complexivo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;
    private String nombre_estudiante;
    private String apellido_estudiante;
    private String fecha_de_nacimiento;
    private String correo;

    // Relación uno a muchos con Matricula
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();
}
