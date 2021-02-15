package com.spring.ionic.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ionic.domain.Categoria;
import com.spring.ionic.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> find(@PathVariable Long id){
			List<Categoria> categoria = categoriaService.buscar();
			return ResponseEntity.ok(categoria);
		}
}
