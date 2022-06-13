package com.camacho.pract.service.db;

import com.camacho.pract.model.Vacante;
import com.camacho.pract.repository.VacantesRepository;
import com.camacho.pract.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<Vacante> buscarByExapmle(Example<Vacante> example) {
        return vacantesRepo.findAll(example);
    }

    @Override
    public Page<Vacante> buscarTodas(Pageable page) {
        return vacantesRepo.findAll(page);
    }
}
