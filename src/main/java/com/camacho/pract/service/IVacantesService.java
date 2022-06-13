package com.camacho.pract.service;

import com.camacho.pract.model.Vacante;
import org.springframework.data.domain.Example;


import java.util.List;

public interface IVacantesService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer idVacante);
    void guardar(Vacante vacante);
    List<Vacante> buscarDestacadas();

    void eliminar(Integer idVacante);

    List<Vacante> buscarByExapmle(Example<Vacante> example);
}
