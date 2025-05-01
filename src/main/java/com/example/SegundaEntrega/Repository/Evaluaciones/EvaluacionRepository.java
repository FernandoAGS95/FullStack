package com.example.SegundaEntrega.Repository.Evaluaciones;

import org.springframework.stereotype.Repository;

import com.example.SegundaEntrega.Model.Evaluaciones.Evaluacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EvaluacionRepository {
    private Map<String, Evaluacion> evaluaciones = new ConcurrentHashMap<>();

    public Evaluacion save(Evaluacion evaluacion) {
        evaluaciones.put(evaluacion.getId(), evaluacion);
        return evaluacion;
    }

    public Evaluacion findById(String id) {
        return evaluaciones.get(id);
    }

    public List<Evaluacion> findByCurso(String curso) {
        return evaluaciones.values().stream()
                .filter(e -> e.getIdCurso().equals(curso))
                .toList();
    }
}
