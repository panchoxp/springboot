package com.complexivo.servicio;

import com.complexivo.modelo.Estudiante;
import com.complexivo.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;
    //leer servicio
    public List<Estudiante> listaDeEstuduantes(){
        return estudianteRepositorio.findAll();
    }
    //guardar servicio
    public void guardarEstudiante(Estudiante estudiante){
        estudianteRepositorio.save(estudiante);
    }
    //obtener 1 solo dato - id
    public Optional<Estudiante> estudianteId(Long id){
        return estudianteRepositorio.findById(id);
    }

    //actualizar servicio
    public void actualizarEstuante(Estudiante estudiante){
        estudianteRepositorio.save(estudiante);
    }

    //eliminar servicio
    public void eliminarEstudiante(Long id){
        estudianteRepositorio.deleteById(id);
    }
}
