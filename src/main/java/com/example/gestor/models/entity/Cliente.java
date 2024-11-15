package com.example.gestor.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@Column(name="identificacion")
	private int identificacion;
	@Column(name="nacionalidad")
	private String nacionalidad;
	@Column(name="indicador")
	private String Indicador;
	@Column(name="numero_celular")
	private String numero_celular;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="correo_electronico")
	private String correo_electronico;
	public Cliente() {
		super();
	}
	public Cliente(int identificacion, String nacionalidad, String indicador, String numero_celular, String nombres,
			String apellidos, String correo_electronico) {
		super();
		this.identificacion = identificacion;
		this.nacionalidad = nacionalidad;
		Indicador = indicador;
		this.numero_celular = numero_celular;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo_electronico = correo_electronico;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getIndicador() {
		return Indicador;
	}
	public void setIndicador(String indicador) {
		Indicador = indicador;
	}
	public String getNumero_celular() {
		return numero_celular;
	}
	public void setNumero_celular(String numero_celular) {
		this.numero_celular = numero_celular;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	

}
