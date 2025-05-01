package com.example.SegundaEntrega.Service.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SegundaEntrega.Model.Usuario.Alumno;
import com.example.SegundaEntrega.Model.Usuario.Apoderado;
import com.example.SegundaEntrega.Model.Usuario.Profesor;
import com.example.SegundaEntrega.Model.Usuario.Usuario;
import com.example.SegundaEntrega.Repository.Usuarios.ProfesorRepository;

@Service
public class UsuariosService {
  private Map<String, Usuario> usuarios = new HashMap<>();
  private Map<String, List<Alumno>> alumnosPorCurso = new HashMap<>();
 
    //*Repositorios */
  
    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired(required = false)
    private Apoderado apoderadoRepository;

    @Autowired(required = false)
    private Alumno alumnoRepository;
    //*FIN Repositorios */
   


    //*PROFESOR */
    
    public List<Profesor> getProfesores(){
        System.out.println(profesorRepository.getListaProfesores());
        return profesorRepository.getListaProfesores();
    }
    public Profesor getProfesorByRut(String rut){
        return profesorRepository.buscarProfesorPorRut(rut);
    }
    public Profesor postProfesor(Profesor profesor){
        return profesorRepository.crearProfesor(profesor);
    }

    //*FIN PROFESOR */
    //*ALUMNO */

    //*FIN ALUMNO */

    //*Apoderado */

     //*FIN Apoderado */


}
