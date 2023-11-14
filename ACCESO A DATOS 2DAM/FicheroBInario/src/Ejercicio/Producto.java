package Ejercicio;

import java.io.Serializable;

public class Producto implements Serializable{
	
	String articulo;
	int precio;
	int existencias;
	
	public Producto(String n,int i,int i1) {
		this.articulo=n;
		this.precio=i;
		this.existencias=i1;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public String muestraInfo() {
		return "El "+articulo+" vale "+precio+" euro/s y hay "+existencias+" unidades";
	}

}
