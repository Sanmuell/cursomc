package com.spring.ionic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ionic.domain.Categoria;
import com.spring.ionic.exceptions.ObjectNotFoundException;
import com.spring.ionic.repository.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;


	public Categoria buscar(Long id) throws ObjectNotFoundException {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" +id+ ", tipo:"
				+ Categoria.class.getName()));

	}
}
