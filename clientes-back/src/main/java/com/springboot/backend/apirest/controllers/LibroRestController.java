package com.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.apirest.models.entity.Libro;
import com.springboot.backend.apirest.models.services.ILibrosService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class LibroRestController {
	
	@Autowired
	private ILibrosService servicio;
	
	@GetMapping("/libros")
	public List<Libro> index(){
		return servicio.findAll();
	}
	
	@GetMapping("/libros/page/{page}")
	public Page<Libro> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page,4);
		return servicio.findAll(pageable);
	}
	
	@GetMapping("/libros/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Libro libro = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			libro = servicio.findbyId(id);
		}catch(DataAccessException e){
			response.put("mensaje","Ha ocurrido un error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(libro == null) {
			response.put("mensaje","El libro con ID " + id + " no existe en base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}
	
	@PostMapping("/libros")
	public ResponseEntity<?> create(@Valid @RequestBody Libro libro, BindingResult result ) {
		Libro libroCreado = null;
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errores = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errores", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			libroCreado = servicio.save(libro);
		}catch(DataAccessException e){
			response.put("mensaje","Ha ocurrido un error al insertar en  la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Se ha creado el libro " +  libroCreado.getTitulo() + " con exito");
		response.put("libro", libroCreado);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/libros/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Libro libro, BindingResult result, @PathVariable Long id) {
		Libro libroActual = null;
		Libro libroNuevo = null;
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errores = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errores", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			libroActual = servicio.findbyId(id);
			
			libroActual.setAutor(libro.getAutor());
			libroActual.setTitulo(libro.getTitulo());
			
			libroNuevo = servicio.save(libroActual);
		}catch(DataAccessException e){
			response.put("mensaje","Ha ocurrido un error con la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "El libro " + libroNuevo.getTitulo() + " se ha actualizado con exito");
		response.put("libro", libroNuevo);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/libros/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String,Object> response = new HashMap<>();
		
		try {
			servicio.delete(id);
		}catch(DataAccessException e){
			response.put("mensaje","Ha ocurrido un error con la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("mensaje", "El libro se ha eliminado con exito");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		
	}
	

}
