package com.camacho.pract.service.db;

import com.camacho.pract.model.Categoria;
import com.camacho.pract.repository.CategoriasRepository;
import com.camacho.pract.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {
    @Autowired
    private CategoriasRepository categoriasRepo;
    @Override
    public void guardar(Categoria categoria) {
        categoriasRepo.save(categoria);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return categoriasRepo.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
