package com.example.SegundaEntrega.Repository.Usuarios;
import org.springframework.stereotype.Repository;

import com.example.SegundaEntrega.Model.Profesor;


import java.util.List;
import java.util.ArrayList;

@Repository
public class ProfesorRepository {

    private List<Profesor> listaProfesores = new ArrayList<>();

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public Profesor buscarProfesorPorRut(String rut) {
        
        for (Profesor profesor : listaProfesores) {
            if (profesor.getRut().equals(rut)) {
                return profesor;
            }
        }
        return null;
    }

    public Profesor crearProfesor(Profesor profesor) {
        listaProfesores.add(profesor);
        return profesor;
    }

}
