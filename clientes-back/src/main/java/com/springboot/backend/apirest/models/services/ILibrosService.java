package com.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.backend.apirest.models.entity.Libro;

public interface ILibrosService {
	
	public List<Libro> findAll();
	
	public Page<Libro> findAll(Pageable pageable);
	
	public Libro findbyId(Long id);
	
	public Libro save(Libro libro);
	
	public void delete(Long id);

}
