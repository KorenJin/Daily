package uniandes.dpoo.taller1.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class Restaurante{
	
	private ArrayList<Pedido> pedidos;
	private boolean pedidoEnCurso;
	private static ArrayList<Ingrediente> ingredientes;
	private ArrayList<Combo> combos;
	private HashMap<String,ProductoMenu> menuBase;
	
	// MAIN OPERATIONS //
	
	public Restaurante() {
		ingredientes = new ArrayList<Ingrediente>();
		pedidos = new ArrayList<Pedido>();
		combos = new ArrayList<Combo>();
		menuBase = new HashMap<String,ProductoMenu>();
	}
	
	public void iniciarPedido(String nombreCliente, String dirreccionCliente) {}
	
	public void cerrarYGuardarPedido() {}
	
	// GETTERS //
	
	public Pedido getPedidoEnCurso() {
		Pedido ret = new Pedido("","");
		return ret;
	}
	
	public HashMap<String,ProductoMenu> getMenuBase() {return menuBase;}
	
	public ArrayList<Ingrediente> getIngredientes() {return ingredientes;}
	
	public ArrayList<Combo> getCombos() {return combos;}
	
	// LOAD DATA //
	
	public void cargarInformacionRestaurante(File archivoIngredientes,File archivoMenu, File archivoCombos) {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	
	private void cargarIngredientes(File archivoIngredientes) {
		try {
		      Scanner myReader = new Scanner(archivoIngredientes);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] elements = data.split(";");
		        String name = elements[0];
		        int price = Integer.parseInt(elements[1]);
		        Ingrediente ingrediente = new Ingrediente(name,price);
		        ingredientes.add(ingrediente);
		      }
		      myReader.close();
		    } 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	private void cargarMenu(File archivoMenu) {
		try {
		      Scanner myReader = new Scanner(archivoMenu);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] elements = data.split(";");
		        String name = elements[0];
		        int price = Integer.parseInt(elements[1]);
		        ProductoMenu productomenu = new ProductoMenu(name,price);
		        menuBase.put(name,productomenu);
		      }
		      myReader.close();
		    }
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	private void cargarCombos(File archivoCombos) {
		try {
		      Scanner myReader = new Scanner(archivoCombos);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] elements = data.split(";");
		        String name = elements[0];
		        int discount = Integer.parseInt(elements[1].replace("%",""))/100;
		        Combo combo = new Combo(name,discount);
		        ProductoMenu itemcombo1 = menuBase.get(elements[2]);
		        combo.agregarItemACombo(itemcombo1);
		        ProductoMenu itemcombo2 = menuBase.get(elements[3]);
		        combo.agregarItemACombo(itemcombo2);
		        ProductoMenu itemcombo3 = menuBase.get(elements[4]);
		        combo.agregarItemACombo(itemcombo3);
		        combos.add(combo);
		      }
		      myReader.close();
		    }
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	
}