package com.example.gestor.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestor.models.entity.Usuario;
import com.example.gestor.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
   @Autowired
   UsuarioRepository usuarioRepository;
   
	@Override
	public Usuario save(Usuario u) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(u);
	}

	@Override
	public String longin(String user, String ctr) {
		// TODO Auto-generated method stub
		Usuario usuario=usuarioRepository.findByUsername(user);
		
		if(usuario==null)
		{
			return "Usuario no encontrado";
		}
		if(!usuario.getPassword().equals(ctr)) {
			return "Contrasenia Incorrecta";
			
		}
		return "Inicio de sesion Exitoso";
	}

}
