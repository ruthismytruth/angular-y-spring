package com.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.apirest.models.entity.Libro;

public interface ILibroDAO  extends JpaRepository<Libro, Long>{

}
