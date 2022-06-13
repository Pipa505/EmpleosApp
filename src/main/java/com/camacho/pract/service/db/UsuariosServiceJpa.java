package com.camacho.pract.service.db;

import com.camacho.pract.model.Usuario;
import com.camacho.pract.repository.UsuariosRepository;
import com.camacho.pract.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class UsuariosServiceJpa implements IUsuariosService {
    @Autowired
    UsuariosRepository usuariosRepo;
    @Override
    public void guardar(Usuario usuario) {
        usuariosRepo.save(usuario);
    }

    @Override
    public void eliminar(Integer idUsuario) {
        usuariosRepo.deleteById(idUsuario);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuariosRepo.findAll();
    }
}
