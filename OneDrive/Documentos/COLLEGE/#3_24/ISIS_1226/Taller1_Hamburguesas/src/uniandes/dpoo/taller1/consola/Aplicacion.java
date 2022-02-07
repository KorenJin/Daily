package uniandes.dpoo.taller1.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.util.Scanner;

import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.Pedido;
import uniandes.dpoo.taller1.modelo.ProductoMenu;
import uniandes.dpoo.taller1.modelo.Restaurante;

public class Aplicacion{
	
	private static Restaurante restaurante = new Restaurante();
	private static ArrayList<Combo> combos = restaurante.getCombos();
	private static ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
	
	private static String dirArchivoIngredientes = "C:\\Users\\Ronald\\OneDrive\\Documentos\\COLLEGE\\Taller1_Hamburguesas\\data\\ingredientes.txt";
	private static String dirArchivoCombos = "C:\\Users\\Ronald\\OneDrive\\Documentos\\COLLEGE\\Taller1_Hamburguesas\\data\\combos.txt";
	private static String dirArchivoMenu = "C:\\Users\\Ronald\\OneDrive\\Documentos\\COLLEGE\\Taller1_Hamburguesas\\data\\menu.txt";
	
	public static void mostrarMenu() {
		String msg = "Bienvenido!"
				+ "\n1. Hacer un pedido"
				+ "\n2. Ver combos"
				+ "\n3. Ver ingredientes"
				+ "\n4. "
				+ "\n5. "
				+ "\n0. Exit";
		System.out.println(msg);
	}

	public static void ejecutarOpcion(int option) {
		
		if (option == 0) System.exit(0);
		if (option == 1) hacerPedido();
		if (option == 2) mostrarCombos();
		if (option == 3) mostrarIngredientes();
		if (option == 4);
		if (option == 5);
	}
	
	public static void hacerPedido() {
		mostrarCombos();
		int option = Integer.parseInt(input("Que combo se te antoja hoy?"));
		Combo combo = combos.get(option);
		String name = input("Cual es tu nombre?");
		String address = input("Cual es tu dirreccion?");
		Pedido pedido = new Pedido(name,address);
		mostrarIngredientes();
		int extra = Integer.parseInt(input("Te gustaria agregar algo de nuestra lista de ingredientes? (escribe 0 si la respuesta es no)"));
		if (extra > 0){
			pedido.agregarProducto(ingredientes.get(extra));
		}
		pedido.agregarProducto(combo);
		System.out.println("El costo de tu compra sera: "+pedido);
	}
	
	public static void mostrarCombos() {
		for (int i= 0; i < combos.size();i++) {
			Combo item = combos.get(i);
			System.out.println("<<COMBOS>>\n"+(i+1)+". "+item.getNombre()+" $"+item.getPrecio()+"\n");
		}
	}
	public static void mostrarIngredientes() {
		for (int i= 0; i < ingredientes.size();i++) {
			Ingrediente item = ingredientes.get(i);
			System.out.println("<<INGREDIENTES>>\n"+(i+1)+". "+item.getNombre()+" $"+item.getCostoAdicional()+"\n");
		}
	}
	
	public static void main(String[] args) {
		
		File archivoIngredientes = new File(dirArchivoIngredientes);
		File archivoCombos = new File(dirArchivoCombos);
		File archivoMenu = new File(dirArchivoMenu);
		restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
		
		mostrarMenu();
		while (true) {
			try {
				int option = Integer.parseInt(input("Selecciona una opcion"));
				ejecutarOpcion(option);
			}
			catch (NumberFormatException e){
				System.out.println("Ingresa un numero de opcion valido");
			}
		}
	}
	
	public static String input(String mensaje){
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
}