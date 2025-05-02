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
    
    public boolean isCalificada() {
        return !ausente && !pendienteRevision && valor != null;
    }
}