package uniandes.dpoo.taller1.modelo;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.HashMap;

public class test {
	
	private ArrayList<Pedido> pedidos;
	private boolean pedidoEnCurso;
	private static ArrayList<Ingrediente> ingredientes;
	private ArrayList<Combo> combos;
	private ArrayList<ProductoMenu> menuBase;
	
	private static String dirArchivoIngredientes = "C:\\Users\\Ronald\\OneDrive\\Documentos\\COLLEGE\\Taller1_Hamburguesas\\data\\ingredientes.txt";
	
	public test() {
		ingredientes = new ArrayList<Ingrediente>();
	}
	
	public static void main(String[] args) {
		test restaurant = new test();
		try {
		      File myObj = new File(dirArchivoIngredientes);
		      Scanner myReader = new Scanner(myObj);
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
}