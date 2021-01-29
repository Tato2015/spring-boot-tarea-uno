package com.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}
