package com.example.SegundaEntrega.Model.Evaluaciones;

import lombok.Data;
import java.util.List;
@Data
public class Asignatura {
    private String id;
    private String nombre;
    private String curso;
    private String idProfesor;
    private List<String> alumnosInscritos;
}
