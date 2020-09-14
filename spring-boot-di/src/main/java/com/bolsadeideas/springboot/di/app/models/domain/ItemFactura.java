package com.bolsadeideas.springboot.di.app.models.domain;

public class ItemFactura {
	
	private Producto producto;
	private Integer cantidad;
	
	public ItemFactura() {
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemFactura [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
	
	

}
