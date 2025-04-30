package com.example.SegundaEntrega.Service.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.SegundaEntrega.Model.Alumno;
import com.example.SegundaEntrega.Model.Apoderado;
import com.example.SegundaEntrega.Model.Profesor;
import com.example.SegundaEntrega.Model.Usuario;
import com.example.SegundaEntrega.Repository.Usuarios.ProfesorRepository;

public class UsuariosService {
  private Map<String, Usuario> usuarios = new HashMap<>();
  private Map<String, List<Alumno>> alumnosPorCurso = new HashMap<>();

    //*Repositorios */
  
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private Apoderado apoderadoRepository;
    @Autowired
    private Alumno alumnoRepository;
    //*FIN Repositorios */
    public UsuariosService() {
        // Datos de prueba iniciales
        Profesor profesor1 = new Profesor("profe1", "profe123", "Juan", "Pérez");
        profesor1.agregarAsignatura("Matemáticas");
        profesor1.agregarCurso("4A");
        registrarUsuario(profesor1);

        Alumno alumno1 = new Alumno("alumno1", "alumno123", "Ana", "Gómez", "4A");
        registrarUsuario(alumno1);

        Apoderado apoderado1 = new Apoderado("apod1", "apod123", "Carlos", "Gómez", "+56912345678");
        apoderado1.setAlumnoACargo(alumno1);
        registrarUsuario(apoderado1);
    }

    //*ADMIN */
    public void registrarUsuario(Usuario usuario) {
        usuario.setId(UUID.randomUUID().toString());
        usuarios.put(usuario.getUsername(), usuario);

        if (usuario instanceof Alumno alumno) {
            alumnosPorCurso.computeIfAbsent(alumno.getCurso(), k -> new ArrayList<>()).add(alumno);
        }
    }

    //*PROFESOR */
    

    public List<Profesor> getProfesores(){
        return profesorRepository.getListaProfesores();
    }
    public Profesor getProfesorByRut(String rut){
        return profesorRepository.buscarProfesorPorRut(rut);
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
