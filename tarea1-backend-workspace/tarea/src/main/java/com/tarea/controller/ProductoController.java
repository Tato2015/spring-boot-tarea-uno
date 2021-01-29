package com.tarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tarea.exception.ModeloNotFoundException;
import com.tarea.model.Producto;
import com.tarea.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;
	
	/*@PostMapping
	public Producto registrar(@RequestBody Producto producto) throws Exception {
		Producto obj = service.registrar(producto);
		return obj;
	}*/
	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto p) throws Exception{
		Producto obj = service.registrar(p);
		
		// localhost:8080/pacientes/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping
	public List<Producto> listar() throws Exception{
		List<Producto> lista = service.listar();
		return lista;
	}
	
	
	@GetMapping("/{id}")
	public Producto listarPorId(@PathVariable("id") Integer id)throws Exception{
		Producto obj = service.listarPorId(id);
		if(obj.getIdProducto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		return obj;
	}
	
	
	@PutMapping
	public Producto modificar(@RequestBody Producto producto) throws Exception{
		Producto obj = service.modificar(producto);
		return obj;
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id)throws Exception{
		Producto obj = service.listarPorId(id);
		if(obj.getIdProducto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		service.eliminar(id);
	}
	
}
