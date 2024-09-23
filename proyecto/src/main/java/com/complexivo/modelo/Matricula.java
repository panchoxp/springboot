package com.complexivo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matricula;
    private int fecha_matricula;

    // Relación muchos a uno con Estudiante
    @ManyToOne
    @JoinColumn(name = "id_estudianteFK")
    private Estudiante estudiante;

    // Relación muchos a muchos con Curso
    @ManyToMany
    @JoinTable(
            name = "matricula_curso",
            joinColumns = @JoinColumn(name = "id_matricula"),
            inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private List<Curso> cursos = new ArrayList<>();
}

