package com.example.SegundaEntrega.Controller.Evaluacion;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SegundaEntrega.Model.Evaluaciones.NotaAlumno;
import com.example.SegundaEntrega.Service.Evaluaciones.NotasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/alumnos/Notas")
public class NotasAlumnoController {

    @Autowired
    private NotasService notasService;

    @GetMapping
    public List<NotaAlumno> getNotas(@RequestParam String idEvaluacion,@RequestParam String rutAlumno) {
        return notasService.obtenerNotaAlumno(idEvaluacion,rutAlumno);
    }

    @GetMapping("/allNotas")
    public List<NotaAlumno> getTodasLasNotas(@RequestParam String idEvaluacion) {
        return notasService.obtenerNotasPorEvaluacion(idEvaluacion);
    }

    @PostMapping
    public NotaAlumno GuardarNota(@RequestBody NotaAlumno notaAlumno) {
        return notasService.guardarNota(notaAlumno);
    }
    
}