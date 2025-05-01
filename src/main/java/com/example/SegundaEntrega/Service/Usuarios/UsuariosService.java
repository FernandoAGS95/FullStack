package com.example.SegundaEntrega.Service.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SegundaEntrega.Model.Alumno;
import com.example.SegundaEntrega.Model.Apoderado;
import com.example.SegundaEntrega.Model.Profesor;
import com.example.SegundaEntrega.Model.Usuario;
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
    public void agregarNota(String usernameProfesor, String usernameAlumno, double nota) {
        Usuario usuario = usuarios.get(usernameProfesor);
        if (usuario instanceof Profesor profesor) {
            Usuario alumno = usuarios.get(usernameAlumno);
            if (alumno instanceof Alumno) {
                profesor.ponerNota((Alumno) alumno, nota);
            }
        }
    }
    //*FIN PROFESOR */
    //*ALUMNO */
    //*FIN ALUMNO */

    //*Apoderado */
    public List<Double> consultarNotasAlumno(String usernameApoderado) {
        Usuario usuario = usuarios.get(usernameApoderado);
        if (usuario instanceof Apoderado apoderado && apoderado.getAlumnoACargo() != null) {
            return apoderado.getAlumnoACargo().getNotas();
        }
        return new ArrayList<>();
    }
     //*FIN Apoderado */


}
