package com.example.SegundaEntrega.Service.Evaluaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SegundaEntrega.Model.Evaluaciones.NotaAlumno;
import com.example.SegundaEntrega.Repository.Evaluaciones.NotaAlumnoRepository;



@Service
public class NotasService {

    @Autowired
    private  NotaAlumnoRepository notaAlumnoRepository;

    public NotaAlumno guardarNota(NotaAlumno nota){
        return notaAlumnoRepository.save(nota);
    }

    public List<NotaAlumno> obtenerNotaAlumno(String idEvaluacion, String rutAlumno){
        return notaAlumnoRepository.findByAlumno(idEvaluacion + "_" + rutAlumno);
    }
    public List<NotaAlumno> obtenerNotasPorEvaluacion(String idEvaluacion){
        return notaAlumnoRepository.findByEvaluacion(idEvaluacion);
    }
}
