package com.example.SegundaEntrega.Model.Usuario;

import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Data

public class Profesor extends Usuario  {

    @Builder.Default
    private List<String> idCursosAsignados = new ArrayList<>(); // Cambiar de List<String> curso
    @Builder.Default
    private List<String> asignaturas = new ArrayList<>();
    public Profesor(String username, String rut,String password, String nombre, String apellido) {
        super(username, password,  rut,nombre, apellido, RolUsuario.PROFESOR);
    }

    @Override
    public String mostrarInformacion() {
        return String.format("Profesor: %s %s - Asignaturas: %s", 
            getNombre(), getApellido(), String.join(", ", asignaturas));
    }

    public void agregarCurso(String curso) {
        if (!idCursosAsignados.contains(curso)) {
            idCursosAsignados.add(curso);
        }
    }

    public void agregarAsignatura(String asignatura) {
        if (!asignaturas.contains(asignatura)) {
            asignaturas.add(asignatura);
        }
    }
}
