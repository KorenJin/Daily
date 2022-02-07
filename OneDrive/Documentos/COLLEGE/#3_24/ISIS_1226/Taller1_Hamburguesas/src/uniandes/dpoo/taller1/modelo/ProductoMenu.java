package uniandes.dpoo.taller1.modelo;

public class ProductoMenu{
	
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String nombre, int precioBase) {}
	
	public String getNombre() {return nombre;}
	public int getPrecio() {return precioBase;}
	public String generarTextoFactura() {return "";}
	
}