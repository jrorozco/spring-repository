package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("miServicioComplejo")
@Primary
public class MiServicioComplejo implements IServicio{

	
	@Override
	public String operacion() {
		System.out.println("Este es un cambio para el git");
		return "Ejecutando un proceso Complicado!!";
	}

}

