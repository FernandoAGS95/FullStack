package com.example.SegundaEntrega.Repository.Usuarios;



import org.springframework.stereotype.Repository;

import com.example.SegundaEntrega.Model.Usuario.Alumno;

import java.util.List;
import java.util.ArrayList;

@Repository
public class AlumnoRepository {

    private List<Alumno> listaAlumnosGeneral = new ArrayList<>();

    public List<Alumno> getListaAlumnosGeneral() {
        return listaAlumnosGeneral;
    }


    public List<Alumno> findByCurso(String curso) {
        return listaAlumnosGeneral.stream()
                .filter(a -> a.getIdCurso().equals(curso))
                .toList();
    }
    public Alumno findByUserName(String username) {
        for (Alumno alumno : listaAlumnosGeneral) {
            if (alumno.getUsername().equals(username)) {
                return alumno;
            }
        }
        return null; // O lanzar una excepción si no se encuentra el alumno
    }
    public Alumno crearAlumno(Alumno alumno) {
        listaAlumnosGeneral.add(alumno);
        return alumno;
    }
    //TODO : CREAR BUSCARA ASIGNATURAS POR ALUMNO
    //TODO: TRAR APODERADO ALUMNO (?????)
    //TODO: PENSAR EN MAS METODOS
}
