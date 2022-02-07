package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;

public class Combo{
	
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo(String nombreCombo, double descuento) {
		this.itemsCombo = new ArrayList<ProductoMenu>();
		this.nombreCombo = nombreCombo;
		this.descuento = descuento;
	}
	
	public void agregarItemACombo(ProductoMenu itemCombo) {
		itemsCombo.add(itemCombo);
	}
	public double getPrecio() {
		double sum = 0;
		for (int i = 0; i < itemsCombo.size();i++){
			sum += itemsCombo.get(i).getPrecio();
		}
		return sum*descuento;
	}
	public String generarTextoFactura() {return "";}
	public String getNombre() {return nombreCombo;}
	
}