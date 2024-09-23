package com.complexivo.repositorio;

import com.complexivo.modelo.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {
}
