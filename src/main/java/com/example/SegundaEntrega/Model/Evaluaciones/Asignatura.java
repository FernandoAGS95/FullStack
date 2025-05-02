package com.example.SegundaEntrega.Model.Evaluaciones;

import lombok.Data;
import java.util.List;
@Data
public class Asignatura {
    // Una asignatura tiene alumnos inscritos, un profesor y curso asignado
    // Pero un curso puede tener varias asignaturas
    // Un profesor puede tener varias asignaturas
    // Un alumno puede tener varias asignaturas
    // TODO: REVISAR  BIEN EL UML 
    private String id;
    private String nombre;
    private String curso;
    private String idProfesor;
    private List<String> alumnosInscritos;
}
