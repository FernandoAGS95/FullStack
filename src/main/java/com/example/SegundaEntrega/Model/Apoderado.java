package com.example.SegundaEntrega.Model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Apoderado  extends Usuario{
    private Alumno alumnoACargo;
    private String telefono;


    public Apoderado(String username, String password, String nombre, String apellido, String telefono) {
        super(username, password, nombre, apellido, "APODERADO");
        this.telefono = telefono;
    }
    // Métodos específicos
    public void consultarNotas() {
        if (alumnoACargo != null) {
            System.out.println("Notas de " + alumnoACargo.getNombre() + ": " + alumnoACargo.getNotas());
        }
    }

    public void comunicarConProfesor(Profesor profesor, String mensaje) {
        System.out.printf("Mensaje para %s: %s%n", profesor.getNombre(), mensaje);
    }
    @Override
    public String mostrarInformacion() {
        return String.format("Alumno: %s %s - Curso: %s", getNombre(), getApellido());
    }
}
