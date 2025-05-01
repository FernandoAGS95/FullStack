package com.example.SegundaEntrega.Model.Evaluaciones;

import lombok.Data;
import java.util.*;

@Data
public class Evaluacion {
    private String id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String idCurso;
    private String asignatura;
    private String idProfesor;
    private Map<String, Double> notas; // idAlumno -> nota
    private EstadoEvaluacion estado;
    private Double promedioCurso;

    public enum EstadoEvaluacion {
        PLANIFICADA,
        PUBLICADA,
        CALIFICADA,
        REVISADA
    }

    public void calcularPromedio() {
        this.promedioCurso = notas.values().stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
    }


}
