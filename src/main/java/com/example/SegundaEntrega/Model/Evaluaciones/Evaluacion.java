package com.example.SegundaEntrega.Model.Evaluaciones;

import lombok.*;
import lombok.Data;
import java.util.*;

@Data
@Builder
public class Evaluacion {
    
    private Map<String, NotaAlumno> resultados = new HashMap<>();

    private String id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String idCurso;
    private String asignatura;
    private String idProfesor;
    private EstadoEvaluacion estado;
    private Double promedioCurso;

    public enum EstadoEvaluacion {
        PLANIFICADA,
        PUBLICADA,
        CALIFICADA,
        REVISADA
    }

    public void agregarResultado(String rutAlumno, NotaAlumno nota) {
        resultados.put(rutAlumno, nota);
    }
    public Double calcularPromedio() {
        return resultados.values().stream()
            .filter(NotaAlumno::isCalificada)
            .mapToDouble(NotaAlumno::getValor)
            .average()
            .orElse(0.0);
    }

}
