package com.example.SegundaEntrega.Model.Evaluaciones;
import lombok.Data;
import java.util.Date;

@Data
public class Anotaciones {
    private String id;
    private String contenido;
    private Date fecha;
    private String idProfesor;
    private String rutAlumno;
    private TipoAnotacion tipo;

    public enum TipoAnotacion {
        POSITIVA,
        NEUTRAL,
        NEGATIVA
    }
}
