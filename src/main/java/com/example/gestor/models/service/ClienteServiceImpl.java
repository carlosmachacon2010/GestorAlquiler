package com.example.gestor.models.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestor.models.entity.Cliente;
import com.example.gestor.models.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	ClienteRepository clienterepository;
	
	@Override
	public Optional<Cliente> findById(Integer id) {
		
		return clienterepository.findById(id);
	}

	@Override
	public List<Cliente> findAll() {
		
		return clienterepository.findAll();
	}

	@Override
	public Cliente save(Cliente c) {

		return clienterepository.save(c);
	}

	@Override
	public void deleteById(Integer id) {
	
		clienterepository.deleteById(id);
	}

}
