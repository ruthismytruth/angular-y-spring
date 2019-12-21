package com.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.models.dao.ILibroDAO;
import com.springboot.backend.apirest.models.entity.Libro;

@Service
public class LibroServiceImpl implements ILibrosService {
	
	@Autowired
	private ILibroDAO libroDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Libro> findAll() {
		return (List<Libro>) libroDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Libro> findAll(Pageable pageable) {
		return libroDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Libro findbyId(Long id) {		
		return libroDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=false)
	public Libro save(Libro libro) {		
		return libroDAO.save(libro);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Long id) {
		libroDAO.deleteById(id);
	}

}
