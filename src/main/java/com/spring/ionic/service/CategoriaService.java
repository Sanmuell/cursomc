package com.spring.ionic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.ionic.domain.Categoria;
import com.spring.ionic.repository.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	//@GetMapping
	public List<Categoria> buscar() {
		return categoriaRepository.findAll();
	}

	//@GetMapping("/{id}")
	public Categoria find(Long id) throws ObjectNotFoundException {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" +id+ ", tipo:"
				+ Categoria.class.getName()));

	}
}
