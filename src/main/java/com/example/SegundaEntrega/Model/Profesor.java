package com.example.SegundaEntrega.Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data

public class Profesor extends Usuario  {
    @Builder.Default
    private List<String> cursos = new ArrayList<>();
    @Builder.Default
    private List<String> asignaturas = new ArrayList<>();
    public Profesor(String username, String password, String nombre, String apellido) {
        super(username, password, nombre, apellido, "PROFESOR");
    }


    // Métodos específicos
    public void agregarCurso(String curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    public void agregarAsignatura(String asignatura) {
        if (!asignaturas.contains(asignatura)) {
            asignaturas.add(asignatura);
        }
    }

    public void ponerNota(Alumno alumno, double nota) {
        alumno.agregarNota(nota);
    }

    public void agregarAnotacion(Alumno alumno, String anotacion) {
        alumno.getAnotaciones().add(anotacion);
    }

    @Override
    public String mostrarInformacion() {
        return String.format("Alumno: %s %s - Curso: %s", getNombre(), getApellido());
    }
}
