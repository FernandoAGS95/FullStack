package com.example.SegundaEntrega.Repository.Usuarios;



import org.springframework.stereotype.Repository;

import com.example.SegundaEntrega.Model.Alumno;


import java.util.List;
import java.util.ArrayList;

@Repository
public class AlumnoRepository {

    private List<Alumno> listaAlumnosGeneral = new ArrayList<>();

    public List<Alumno> getListaAlumnosGeneral() {
        return listaAlumnosGeneral;
    }

    public List<Alumno> buscarApoderadoRut(String rut) {
        List<Alumno> alumnoEncontrado = new ArrayList<>();
        for (Alumno alumno : listaAlumnosGeneral) {
            if (alumno.getRut().equals(rut)) {
                alumnoEncontrado.add(alumno);
            }
        }
        return alumnoEncontrado;
    }

}
