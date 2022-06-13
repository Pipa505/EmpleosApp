package com.camacho.pract.service;

import com.camacho.pract.model.Categoria;

import java.util.List;


public interface ICategoriasService {
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);

	void eliminar(Integer idCategoria);
}

