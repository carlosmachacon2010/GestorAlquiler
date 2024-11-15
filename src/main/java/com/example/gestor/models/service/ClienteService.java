package com.example.gestor.models.service;

import java.util.List;
import java.util.Optional;

import com.example.gestor.models.entity.Cliente;

public interface ClienteService {
	public Optional<Cliente> findById(Integer id);
	public List<Cliente> findAll();
	public Cliente save(Cliente c);
	public void deleteById(Integer id);

}
