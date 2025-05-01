package com.example.SegundaEntrega.Model.Usuario;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//PORQUE DATA GENERA una EXCEPCION DE SERIALIZACION?
//NO SE PUEDE SERIALIZAR UN OBJETO QUE NO TIENE UN CONSTRUCTOR VACIO
//COmo podemos arreglar esta falla? 
//USANDO @AllArgsConstructor y @NoArgsConstructor
import java.util.Map;

import com.example.SegundaEntrega.Model.Evaluaciones.Anotaciones;
import com.example.SegundaEntrega.Model.Evaluaciones.Asignatura;
import com.example.SegundaEntrega.Model.Evaluaciones.Tarea;


// PEnsar en usar JPA Y CONECTAR CON OCI 
// CREAR RELACIONES ENTRE TABLAS PARA USAR HIBERNATE H2
@Data
@ToString(callSuper = true)
@SuperBuilder

public class Alumno extends Usuario {


    private String idCurso;
    @Builder.Default
    private List<Asignatura> asignaturas = new ArrayList<>();
    @Builder.Default
    private Map<String, Double> notas = new HashMap<>(); // idEvaluacion -> nota
    @Builder.Default
    private List<Tarea> tareas = new ArrayList<>();
    @Builder.Default
    private List<Anotaciones> anotaciones = new ArrayList<>();
    private String idApoderado;

    public Alumno(String username,String rut, String password, String nombre, String apellido, String curso) {
        super(username, rut,password, nombre, apellido, RolUsuario.ALUMNO);
        this.idCurso = curso;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("Alumno: %s %s - Curso: %s", getNombre(), getApellido(), idCurso);
    }

    public double calcularPromedio() {
        return notas.values().stream().mapToDouble(d -> d).average().orElse(0.0);
    }

    public void agregarNota(String idEvaluacion, double nota) {
        notas.put(idEvaluacion, nota);
    }

    public Object getCurso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurso'");
    }

}
