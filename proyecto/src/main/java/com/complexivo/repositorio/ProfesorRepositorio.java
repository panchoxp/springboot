package com.complexivo.repositorio;

import com.complexivo.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {
}
