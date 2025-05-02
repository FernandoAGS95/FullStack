package com.example.SegundaEntrega.Controller.Evaluacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SegundaEntrega.Service.Evaluaciones.EvaluacionService;

@RestController
@RequestMapping("/api/evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;
}
