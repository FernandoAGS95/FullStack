package com.example.SegundaEntrega.Controller.Evaluacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SegundaEntrega.Model.Evaluaciones.Evaluacion;
import com.example.SegundaEntrega.Service.Evaluaciones.EvaluacionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;
    //DOCUMENTAR TODAS LOS ENDPOINTS PARA SWAGFGER USANDO
    // EL @OPERATION, ESTA EN NOTAALUMNO CONTROLLER
    @GetMapping()
    public Evaluacion getEvaluacionPorId(@RequestParam String id) {
        return evaluacionService.encontrarPorId(id);
    }
    @PostMapping
    public Evaluacion crearEvaluacion(@RequestBody Evaluacion evaluacion){
        return evaluacionService.crearEvaluacion(evaluacion);
    }
    @GetMapping("/curso")
    public List<Evaluacion> traerPorCurso(@RequestParam String idCurso){
        return evaluacionService.encontrarPorCurso(idCurso);
    }
    @PutMapping("/actualizar/{id}")
    public Evaluacion actualizarDescripcion(@PathVariable String id, @RequestBody String descripcionNueva) {
        return evaluacionService.actualizarDescripcion(id, descripcionNueva);
    }
    //Eliminar Evaluacion
    @DeleteMapping("/eliminar/{id}")
    public Evaluacion eliminarEvaluacion(@PathVariable String id) {
        return evaluacionService.eliminarEvaluacion(id);

    }
}
