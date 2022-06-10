package com.camacho.pract.service.db;

import com.camacho.pract.model.Vacante;
import com.camacho.pract.repository.VacantesRepository;
import com.camacho.pract.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {
    @Autowired
    VacantesRepository vacantesRepo;
    @Override
    public List<Vacante> buscarTodas() {
        return vacantesRepo.findAll();
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
        Optional<Vacante> optional = vacantesRepo.findById(idVacante);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        vacantesRepo.save(vacante);
    }

    @Override
    public List<Vacante> buscarDestacadas() {
        return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1,"Aprobada");
    }

    @Override
    public void eliminar(Integer idVacante) {
        vacantesRepo.deleteById(idVacante);
    }
}
