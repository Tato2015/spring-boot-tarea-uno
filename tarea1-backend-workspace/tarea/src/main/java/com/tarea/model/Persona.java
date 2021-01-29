package com.tarea.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Persona Model")
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Schema(description = "nombres de la persona")
	@Size(min = 3, message = "{nombres.size}")
	@Column(name = "nombres",length = 50,nullable = false)
	private String nombres;
	
	@Size(min = 3, message = "{apellidos.size}")
	@Column(name = "apellidos",length = 50,nullable = false)
	private String apellidos;
	//orphanRemoval = true
	@OneToMany(mappedBy = "personaX",cascade= {CascadeType.ALL})
	private List<Venta> ventas;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

}
