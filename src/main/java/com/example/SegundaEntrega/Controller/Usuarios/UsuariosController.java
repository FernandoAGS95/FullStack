package com.example.SegundaEntrega.Controller.Usuarios;



import java.util.List;

import com.example.SegundaEntrega.Model.Usuario.Alumno;
import com.example.SegundaEntrega.Model.Usuario.Apoderado;
import com.example.SegundaEntrega.Model.Usuario.Profesor;
import com.example.SegundaEntrega.Service.Usuarios.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuariosController {

    @Autowired
    private  UsuariosService usuarioService;

    public UsuariosController(UsuariosService usuarioService) {
        this.usuarioService = usuarioService;
    }



    //* ADMIN */
    @PostMapping("/admin/profesores")
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return usuarioService.postProfesor(profesor);
    }
    @PostMapping("/admin/alumnos")
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return usuarioService.crearAlumno(alumno);
    }
    @PostMapping("/admin/apoderados")
    public Apoderado crearApoderado(@RequestBody Apoderado apoderado) {
        return usuarioService.crearApoderado(apoderado);
    }
    //* FIN ADMIN */
    /************************************************************ */
    /************************************************************ */
    //* Profesor */
    @GetMapping("/profesores")
    public List<Profesor> buscarProfesores(){
        return usuarioService.getProfesores();
    }
    @GetMapping("/profesores/{rut}")
    public Profesor buscarProfesorPorRut(@PathVariable String rut){
        return usuarioService.getProfesorByRut(rut);
    }
    //* FIN PROFESOR */
    /************************************************************ */
    /************************************************************ */
    //* ALUMNO */
    @GetMapping("/alumnos")
    public List<Alumno> buscarAlumnos(){
        return usuarioService.getListaAlumnosGeneral();
    }
    @GetMapping("/alumnos/{username}")
    public Alumno buscarAlumnoPorUsername(@PathVariable String username){
        return usuarioService.getAlumnoByUserName(username);
    }
    
    //* FIN Alumno */
    /************************************************************ */
    /************************************************************ */
    //* Apoderado */
    @GetMapping("/apoderados/{rut}")
    public Apoderado buscarApoderadoPorRut(@PathVariable String rut){
        return usuarioService.getApoderadoByRUt(rut);
    }

}
