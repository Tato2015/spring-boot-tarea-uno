package com.tarea.service;

import java.util.List;

import com.tarea.model.Persona;

public interface IPersonaService {

	Persona registrar(Persona persona) throws Exception;
	
	Persona modificar(Persona persona) throws Exception;
	
	List<Persona> listar()throws Exception;
	
	Persona listarPorId(Integer id)throws Exception;
	
	void eliminar(Integer id) throws Exception;	
	
}
