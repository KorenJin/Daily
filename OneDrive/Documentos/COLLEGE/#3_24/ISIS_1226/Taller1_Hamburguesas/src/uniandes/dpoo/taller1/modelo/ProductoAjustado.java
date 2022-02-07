package uniandes.dpoo.taller1.modelo;


import java.util.ArrayList;

public class ProductoAjustado{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado(ProductoMenu base) {}
	
	public String getNombre() {return "";}
	public int getPrecio() {return 0;}
	public String generarTextofactura () {return "";}
}