package com.spring.ionic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.ionic.domain.Categoria;
import com.spring.ionic.domain.Produto;
import com.spring.ionic.repository.CategoriaRepository;
import com.spring.ionic.repository.ProdutoRepository;

@SpringBootApplication
public class CursoSpringIonicApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringIonicApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(1L, "Informática");
		Categoria cat2 = new Categoria(2L, "Escritório");

		Produto p1 = new Produto(1L, "Computador", 2000.00);
		Produto p2 = new Produto(2L, "Impressora", 800.00);
		Produto p3 = new Produto(3L, "Mouse", 80.00);

		cat1.getListaProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getListaProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
