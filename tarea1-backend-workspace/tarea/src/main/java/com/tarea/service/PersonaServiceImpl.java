package com.tarea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Persona;
import com.tarea.repository.IPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepo repo;
	
	@Override
	public Persona registrar(Persona persona) throws Exception {
		return repo.save(persona);
	}

	@Override
	public Persona modificar(Persona persona) throws Exception {
		return repo.save(persona);
	}

	@Override
	public List<Persona> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Persona listarPorId(Integer id) throws Exception {
		Optional<Persona> persona = repo.findById(id);		
		return persona.isPresent()?persona.get():new Persona();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);		
	}

	
}
