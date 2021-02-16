package com.spring.ionic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.ionic.domain.Categoria;
import com.spring.ionic.domain.Cidade;
import com.spring.ionic.domain.Cliente;
import com.spring.ionic.domain.Endereco;
import com.spring.ionic.domain.Estado;
import com.spring.ionic.domain.Produto;
import com.spring.ionic.domain.enums.TipoCliente;
import com.spring.ionic.repository.CategoriaRepository;
import com.spring.ionic.repository.CidadeRepository;
import com.spring.ionic.repository.ClienteRepository;
import com.spring.ionic.repository.EnderecoRepository;
import com.spring.ionic.repository.EstadoRepository;
import com.spring.ionic.repository.ProdutoRepository;

@SpringBootApplication
public class CursoSpringIonicApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringIonicApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getListaProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getListaProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo ");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria.silva@gmail.com", "123234235", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("234234234", "32423423"));
		
		Endereco e1 = new Endereco(null, "Rua FLores", "300", "Apto 303", "Jardim", "729999", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 180", "Centro", "345345", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
