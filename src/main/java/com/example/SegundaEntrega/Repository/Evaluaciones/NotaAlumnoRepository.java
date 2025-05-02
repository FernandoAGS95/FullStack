package com.example.SegundaEntrega.Repository.Evaluaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.SegundaEntrega.Model.Evaluaciones.NotaAlumno;

@Repository
public class NotaAlumnoRepository {
    // TODO : CREAR NOTAS; TRAER NOTAS, ENCONTRAR NOTAS X ALUMNO
    // TODO : ENCONTRAR EVALUACION DE NOTAS
     private final Map<String, NotaAlumno> notas = new HashMap<>();

    public NotaAlumno save(NotaAlumno nota) {
        String id = generarId(nota);
        nota.setIdEvaluacion(id.split("_")[0]);
        nota.setRutAlumno(id.split("_")[1]);
        notas.put(id, nota);
        return nota;
    }

    public List<NotaAlumno> findByAlumno(String rutAlumno) {
        List<NotaAlumno> notasAlumno = new ArrayList<>();
        for (Map.Entry<String, NotaAlumno> entry : notas.entrySet()) {
            if (entry.getKey().endsWith(rutAlumno)) {
                notasAlumno.add(entry.getValue());
            }
        }
        return notasAlumno;
    }

    public List<NotaAlumno> findByEvaluacion(String evaluacionId) {
        List<NotaAlumno> notasEvaluacion = new ArrayList<>();
        for (Map.Entry<String, NotaAlumno> entry : notas.entrySet()) {
            if (entry.getKey().startsWith(evaluacionId)) {
                notasEvaluacion.add(entry.getValue());
            }
        }
        return notasEvaluacion;
    }

    private String generarId(NotaAlumno nota) {
        return nota.getIdEvaluacion() + "_" + nota.getRutAlumno();
    }
}
