package com.complexivo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aula;
    private int numero_aula;
    private int capacidad;

    // Relación muchos a muchos con Curso
    @ManyToMany(mappedBy = "aulas")
    private List<Curso> cursos = new ArrayList<>();
}
