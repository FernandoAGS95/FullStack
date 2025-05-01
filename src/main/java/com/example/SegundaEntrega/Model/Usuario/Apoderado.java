package com.example.SegundaEntrega.Model.Usuario;

import java.util.ArrayList;
import java.util.List;



import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Apoderado  extends Usuario{
   private String telefono;
    @Builder.Default
    private List<String> alumnosACargo = new ArrayList<>(); // Lista de IDs de alumnos

    public Apoderado(String username,String rut,String password, String nombre, String apellido, String telefono) {
        super(username,rut, password, nombre, apellido, RolUsuario.APODERADO);
        this.telefono = telefono;
    }
    // Métodos específicos
    

    public void comunicarConProfesor(Profesor profesor, String mensaje) {
        System.out.printf("Mensaje para %s: %s%n", profesor.getNombre(), mensaje);
    }
    @Override
    public String mostrarInformacion() {
        return String.format("Alumno: %s %s - Curso: %s", getNombre(), getApellido());
    }
}
