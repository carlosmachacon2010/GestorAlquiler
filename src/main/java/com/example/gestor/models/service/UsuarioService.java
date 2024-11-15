package com.example.gestor.models.service;

import com.example.gestor.models.entity.Usuario;

public interface UsuarioService {
	public Usuario save(Usuario u);
	public String longin(String user,String ctr);
}
