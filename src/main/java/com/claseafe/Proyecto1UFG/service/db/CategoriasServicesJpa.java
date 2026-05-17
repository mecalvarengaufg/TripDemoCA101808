package com.claseafe.Proyecto1UFG.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.claseafe.Proyecto1UFG.model.Categoria;
import com.claseafe.Proyecto1UFG.repository.ICategoriasRepository;
import com.claseafe.Proyecto1UFG.service.ICategoriaService;

@Primary
@Service
public class CategoriasServicesJpa implements ICategoriaService{
	
	@Autowired
	private ICategoriasRepository categoriaService;
	
	@Override
	public List<Categoria> buscarTodos() {
		
		return categoriaService.findAll();
	}
	
	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional
		= categoriaService.findById(idCategoria);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		
		categoriaService.save(categoria);
	}
}
