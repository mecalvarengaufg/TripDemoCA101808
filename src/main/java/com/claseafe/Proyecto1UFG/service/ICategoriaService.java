package com.claseafe.Proyecto1UFG.service;

import java.util.List;

import com.claseafe.Proyecto1UFG.model.Categoria;

public interface ICategoriaService {

    List<Categoria> buscarTodos();
    Categoria buscarPorId(Integer idCategoria);
    void guardar(Categoria categoria);
}
