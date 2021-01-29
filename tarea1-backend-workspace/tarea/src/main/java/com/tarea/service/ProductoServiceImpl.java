package com.tarea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Producto;
import com.tarea.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo repo;
	
	@Override
	public Producto registrar(Producto producto) throws Exception {
		return repo.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) throws Exception {
		return repo.save(producto);
	}

	@Override
	public List<Producto> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Producto listarPorId(Integer id) throws Exception {
		Optional<Producto> producto = repo.findById(id);
		return producto.isPresent()?producto.get():new Producto();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);		
	}

}
