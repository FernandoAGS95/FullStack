package com.example.SegundaEntrega.Controller.Usuarios;



import java.util.List;

import com.example.SegundaEntrega.Model.Usuario.Profesor;
import com.example.SegundaEntrega.Service.Usuarios.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

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
    //*Endpoints Profesor */

    @GetMapping("/profesores")
    public List<Profesor> buscarProfesores(){
        return usuarioService.getProfesores();
    }

    @PostMapping("/profesores")
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return usuarioService.postProfesor(profesor);
    }


}
