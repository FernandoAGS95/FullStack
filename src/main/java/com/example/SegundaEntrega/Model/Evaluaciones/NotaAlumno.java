package com.example.SegundaEntrega.Model.Evaluaciones;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaAlumno {
    private String idEvaluacion;
    private String rutAlumno;
    private Double valor;
    private boolean ausente;
    private boolean pendienteRevision;
    private String comentario;
    

    // El metodo isCalificada devuelve true si la nota es valida, es decir, si no esta ausente,
    // no esta pendiente de revision y tiene un valor asignado.
    // Si la nota es ausente, pendiente de revision o no tiene un valor asignado,
    // el metodo devuelve false, indicando que la nota no es valida.

    public boolean isCalificada() {
        return !ausente && !pendienteRevision && valor != null;
    }
}