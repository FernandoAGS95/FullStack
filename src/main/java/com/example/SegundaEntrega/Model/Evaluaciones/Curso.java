package com.example.SegundaEntrega.Model.Evaluaciones;
import lombok.Data;
import java.util.List;

@Data
public class Curso {
    private String id;
    private String nombre; // Ej: "4°A", "3°B"
    private String nivel; // Ej: "Primero básico", "Cuarto medio"
    private List<String> idAsignaturas;
    private List<String> rutAlumno;
    private String profesorJefe; // ID del profesor jefe
}
