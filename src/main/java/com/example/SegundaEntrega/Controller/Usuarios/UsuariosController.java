package com.example.SegundaEntrega.Controller.Usuarios;



import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.example.SegundaEntrega.Service.Usuarios.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuariosController {

    @Autowired
    private  UsuariosService usuarioService;
}
