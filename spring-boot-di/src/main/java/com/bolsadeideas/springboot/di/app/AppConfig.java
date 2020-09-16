package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;

@Configuration
public class AppConfig {
	
	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}

	@Bean("miServicioComplejo")
	@Primary
	public IServicio registrarMiServicioComplejo() {
		return new MiServicio();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItemFactura(){
		Producto producto1 = new Producto("Camara Sony", 100D);
		Producto producto2 = new Producto("Bicileta Bianchi aro 26", 200D);
		ItemFactura linea1 = new ItemFactura(producto1,2);
		ItemFactura linea2 = new ItemFactura(producto2,4);
		return Arrays.asList(linea1,linea2);
	}
	
	@Bean("itemsFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemFacturaOficina(){
		Producto producto1 = new Producto("Monitor LG LCD 24 ",250D);
		Producto producto2 = new Producto("Notebook ASUS", 500D);
		Producto producto3 = new Producto("Impresora HP Multifuncional", 80D);
		Producto producto4 = new Producto("Escritorio Oficina", 300D);
		ItemFactura linea1 = new ItemFactura(producto1,2);
		ItemFactura linea2 = new ItemFactura(producto2,1);
		ItemFactura linea3 = new ItemFactura(producto3,1);
		ItemFactura linea4 = new ItemFactura(producto4,1);
		return Arrays.asList(linea1,linea2,linea3,linea4);
	}
}
