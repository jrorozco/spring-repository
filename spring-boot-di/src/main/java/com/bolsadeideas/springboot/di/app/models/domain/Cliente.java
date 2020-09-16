package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

@Repository
@RequestScope
public class Cliente {
	
	
	//estos valores se definene en el .properties en el archivo de configuracion de spring
	@Value("${cliente.nombre}")
	private String nombre;
	
	@Value("${cliente.apellido}")
	private String apellido;
	
	public Cliente() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	
}
