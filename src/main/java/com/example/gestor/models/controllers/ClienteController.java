package com.example.gestor.models.controllers;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestor.models.entity.Cliente;
import com.example.gestor.models.service.ClienteService;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ClienteController {
  
	
	@Autowired
	ClienteService cleinteService;
	
	@GetMapping("/{id}")
    public Optional<Cliente> buscarporId(@PathVariable Integer id){
		return cleinteService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		return cleinteService.findAll();
	}
	
	@PostMapping
	public Cliente registrar(@RequestBody Cliente c) {
		return cleinteService.save(c);
		
	}
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Integer id) {
		cleinteService.deleteById(id);
		
	}
	@PutMapping("/actualizar/{id}")
	public Cliente actualizar(@RequestBody Cliente c,@PathVariable Integer id){
		Cliente cEnBd=cleinteService.findById(id).get();
		cEnBd.setIdentificacion(c.getIdentificacion());
		cEnBd.setIndicador(c.getIndicador());
		cEnBd.setNacionalidad(c.getNacionalidad());
		cEnBd.setNombres(c.getNombres());
		cEnBd.setApellidos(c.getApellidos());
		cEnBd.setCorreo_electronico(c.getCorreo_electronico());
		cleinteService.save(cEnBd);
		return c;
		
	}
}
