package com.complexivo.controlador;

import com.complexivo.modelo.Estudiante;
import com.complexivo.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio estudianteServicio;

    //CRUD

    //leer
    @GetMapping("/estudiantes")
    public String listaEstudiante(Model model){
        List<Estudiante> estudiantes=estudianteServicio.listaDeEstuduantes();
        model.addAttribute("estudiantes",estudiantes);
        return "Estudiante/vista";
    }
    //crear
        //enviar al formulario
    @GetMapping("/estudiantes/nuevo")
    public String formularioCliente(Model model){
        model.addAttribute("estudiante",new Estudiante());
        return "Estudiante/formulario";
    }
        //guardar cambios
    @PostMapping("/estudiantes/guardar")
    public String guardarEstudiante(Estudiante estudiante){
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";//cuando termina el proceso envia a leer
    }

        //actualizar
        //trae datos mediante el id
    @GetMapping("/estudiantes/editar/{id}")
    public String formularioEditarEstudiante(@PathVariable Long id, Model model){
        Optional<Estudiante>estudiante=estudianteServicio.estudianteId(id);
        if (estudiante.isPresent()){
            model.addAttribute("estudiante",estudiante.get());
            return "Estudiante/formulario";
        }else {
            return "redirect:/estudiantes";//cuando termina el proceso envia a leer
        }
    }
        //sobreescribe los datos modificados
    @PostMapping("/estudiantes/actualizar")
    public String actualizarEstudiante(Estudiante estudiante){
        estudianteServicio.actualizarEstuante(estudiante);
        return "redirect:/estudiantes";
    }

    //eliminar
    @GetMapping("/estudiantes/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        estudianteServicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
