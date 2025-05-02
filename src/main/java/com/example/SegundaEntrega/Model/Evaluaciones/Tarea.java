package com.example.SegundaEntrega.Model.Evaluaciones;
import lombok.Data;
import java.util.Date;

@Data
public class Tarea {
    private String id;
    private String titulo;
    private String descripcion;
    private Date fechaEntrega;
    private String idAsignatura;
    private String idProfesor;
    // TODO: UNIR CON MIRCROSERVICIO MATERIAL MAS ADELANTE
}
