package uniandes.dpoo.taller1.modelo;

import java.io.File;
import java.util.ArrayList;

public class Pedido{
	
	private ArrayList<Object> itemsPedido;
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	public Pedido(String nombreCliente, String direccionCliente) {}
	public int getIdPedido() {return idPedido;}
	public void agregarProducto(Object nuevoItem) {
		itemsPedido.add(nuevoItem);
	}
	
	private double getPrecioNetoPedido() {
		double sum = 0;
		for (Object item : itemsPedido) {
			if (item.getClass().equals(ProductoMenu.class)) {
				sum += ((ProductoMenu) item).getPrecio();
			}
			else if (item.getClass().equals(Ingrediente.class)) {
				sum += ((Ingrediente) item).getPrecio();
			}
			else if (item.getClass().equals(Combo.class)) {
				sum += ((Combo) item).getPrecio();
			}
		}
		return sum;
	} 
	private double getPrecioTotalPedido() {
		double sum = getPrecioNetoPedido();
		return sum * 1.19;
	}
	private double getPrecioIVAPedido() {
		double sum = getPrecioNetoPedido();
		return sum * 0.19;
	}
	private String generarTextoFactura() {return "";}
	
	public void guardarFactura(File archivo) {}
}