package com.example.SegundaEntrega.Service.Evaluaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SegundaEntrega.Model.Evaluaciones.Evaluacion;
import com.example.SegundaEntrega.Repository.Evaluaciones.EvaluacionRepository;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }
    public Evaluacion encontrarPorId(String id){
        return evaluacionRepository.findById(id);
    }
    public List<Evaluacion> encontrarPorCurso(String idCurso){
        return evaluacionRepository.findByCurso(idCurso);
    }
    public Evaluacion actualizarDescripcion(String id, String descripcion) {
        return evaluacionRepository.updateDescripcion(id, descripcion);
    }
    public Evaluacion eliminarEvaluacion(String id) {
        return evaluacionRepository.deleteEvaluacion(id);

}
}
