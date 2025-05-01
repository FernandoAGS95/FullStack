package com.example.SegundaEntrega.Service.Usuarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SegundaEntrega.Model.Evaluaciones.Evaluacion;
import com.example.SegundaEntrega.Model.Evaluaciones.NotaAlumno;
import com.example.SegundaEntrega.Model.Evaluaciones.Tarea;
import com.example.SegundaEntrega.Model.Usuario.Alumno;
import com.example.SegundaEntrega.Model.Usuario.Apoderado;
import com.example.SegundaEntrega.Model.Usuario.Profesor;
import com.example.SegundaEntrega.Model.Usuario.Usuario;
import com.example.SegundaEntrega.Repository.Usuarios.AlumnoRepository;
import com.example.SegundaEntrega.Repository.Usuarios.ApoderadoRepository;
import com.example.SegundaEntrega.Repository.Usuarios.ProfesorRepository;

@Service
public class UsuariosService {
  private Map<String, Usuario> usuarios = new HashMap<>();
  private Map<String, List<Alumno>> alumnosPorCurso = new HashMap<>();
 
    //*Repositorios */
  
    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ApoderadoRepository apoderadoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;
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
    public Alumno crearAlumno(Alumno alumno){
        return alumnoRepository.crearAlumno(alumno);
    }
    public List<Alumno> getListaAlumnosGeneral(){
        return alumnoRepository.getListaAlumnosGeneral();
    }
    public Alumno getAlumnoByUserName(String username){
        return alumnoRepository.findByUserName(username);
    }



    //*FIN ALUMNO */

    //*Apoderado */
    public Apoderado crearApoderado(Apoderado apod){
        return apoderadoRepository.crearApoderado(apod);
    }
    public Apoderado getApoderadoByRUt(String rut){
        return apoderadoRepository.buscarApoderadoPorRut(rut);
    }
     //*FIN Apoderado */


}
