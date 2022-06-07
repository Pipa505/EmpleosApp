package com.camacho.pract.service;

import com.camacho.pract.model.Categoria;
import com.camacho.pract.model.Vacante;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class CategoriasServiceImp implements ICategoriasService{

    private List<Categoria> lista = null;

    public CategoriasServiceImp(){
        lista = new LinkedList<>();
    }

    @Override
    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria c : lista){
            if (c.getId()==idCategoria){
                return c;
            }
        }
        return null;
    }


}

