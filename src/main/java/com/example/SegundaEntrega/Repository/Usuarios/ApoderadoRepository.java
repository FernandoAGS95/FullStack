package com.example.SegundaEntrega.Repository.Usuarios;





import org.springframework.stereotype.Repository;

import com.example.SegundaEntrega.Model.Usuario.Apoderado;

import java.util.List;
import java.util.ArrayList;

@Repository
public class ApoderadoRepository {

    private List<Apoderado> listaApoderados = new ArrayList<>();

    public List<Apoderado> getListaApoderados() {
        return listaApoderados;
    }

    public List<Apoderado> buscarApoderadoPorRut(String rut) {
        List<Apoderado> apoderadosEncontrados = new ArrayList<>();
        for (Apoderado apoderado : listaApoderados) {
            if (apoderado.getRut().equals(rut)) {
                apoderadosEncontrados.add(apoderado);
            }
        }
        return apoderadosEncontrados;
    }

    
}
