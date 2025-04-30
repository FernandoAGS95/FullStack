package com.example.SegundaEntrega.Model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
//PORQUE DATA GENERA una EXCEPCION DE SERIALIZACION?
//NO SE PUEDE SERIALIZAR UN OBJETO QUE NO TIENE UN CONSTRUCTOR VACIO
//COmo podemos arreglar esta falla? 
//USANDO @AllArgsConstructor y @NoArgsConstructor

// PEnsar en usar JPA Y CONECTAR CON OCI 
// CREAR RELACIONES ENTRE TABLAS PARA USAR HIBERNATE H2
@Data
@ToString(callSuper = true)
@SuperBuilder

public class Alumno extends Usuario {


    private String curso;
    @Builder.Default
    private List<Double> notas = new ArrayList<>();
    @Builder.Default
    private List<String> tareas = new ArrayList<>();
    @Builder.Default
    private List<String> anotaciones = new ArrayList<>();

    public Alumno(String username, String password, String nombre, String apellido, String curso) {
        super(username, password, nombre, apellido, "ALUMNO");
        this.curso = curso;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("Alumno: %s %s - Curso: %s", getNombre(), getApellido(), curso);
    }

    // Métodos específicos (sin getters/setters gracias a Lombok)
    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        return notas.stream().mapToDouble(d -> d).average().orElse(0.0);
    }

}
