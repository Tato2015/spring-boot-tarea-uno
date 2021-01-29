package com.tarea.service;

import java.util.List;

import com.tarea.model.Producto;

public interface IProductoService {
	
	Producto registrar(Producto producto) throws Exception;
	
	Producto modificar(Producto producto) throws Exception;
	
	List<Producto> listar() throws Exception;
	
	Producto listarPorId(Integer id) throws Exception;
	
	void eliminar(Integer id) throws Exception;

}
