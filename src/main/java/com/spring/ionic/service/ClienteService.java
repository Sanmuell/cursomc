package com.spring.ionic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ionic.domain.Cliente;
import com.spring.ionic.exceptions.ObjectNotFoundException;
import com.spring.ionic.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;


	public Cliente buscar(Long id) throws ObjectNotFoundException {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" +id+ ", tipo:"
				+ Cliente.class.getName()));

	}
}
