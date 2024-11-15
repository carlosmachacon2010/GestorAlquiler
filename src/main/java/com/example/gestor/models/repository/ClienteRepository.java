package com.example.gestor.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.gestor.models.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
