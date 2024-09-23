package com.complexivo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;
    @Column(name = "nombreCurso", length = 50)
    private String curso_nombre;
    private String descripcion_curso;
    private String creditos_curso;

    // Relación muchos a muchos con Matricula
    @ManyToMany(mappedBy = "cursos")
    private List<Matricula> matriculas = new ArrayList<>();

    // Relación muchos a muchos con Aula
    @ManyToMany
    @JoinTable(
            name = "curso_aula",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_aula")
    )
    private List<Aula> aulas = new ArrayList<>();
}

