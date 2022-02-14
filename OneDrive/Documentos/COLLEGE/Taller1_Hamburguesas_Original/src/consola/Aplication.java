/**
 * 
 */
package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Combo;
import modelo.Ingredient;
import modelo.MenuProduct;
import modelo.Product;
import modelo.Restaurant;

/**
 * @author Ronald
 *
 */
public class Aplication {
	
	private static Restaurant restaurant = new Restaurant(); // CHANGED
	private static String ingredientsFileDir = "C:\\Users\\Ronald\\OneDrive\\Documentos\\COLLEGE\\Taller1_Hamburguesas\\data\\ingredientes.txt"; //CHANGED
	private static String menuFileDir = "C:\\Users\\Ronald\\OneDrive\\Documentos\\COLLEGE\\Taller1_Hamburguesas\\data\\menu.txt"; //CHANGED
	private static String combosFileDir = "C:\\Users\\Ronald\\OneDrive\\Documentos\\COLLEGE\\Taller1_Hamburguesas\\data\\combos.txt"; //changed

	private static ArrayList<Combo> combos;
	private static HashMap<String,MenuProduct> baseMenu;
	private static ArrayList<Ingredient> ingredients;
	
	public static ArrayList<Product> findSelectedProduct(int selected, ArrayList<Product> orderItems) {
		if (selected < combos.size()) { // THE CLIENT CHOSE A COMBO
			for (MenuProduct i: combos.get(selected).getItemsCombo()) {
				orderItems.add(i);
			}
			System.out.println("You chose "+combos.get(selected).getName()+".\n");
		} else { // THE CLIENT DIDN'T CHOSE A COMBO, BUT A PRODUCT FORM BASIC MENU
			int idx = selected - combos.size();
			MenuProduct product = baseMenu.get(baseMenu.keySet().toArray()[idx]);
			orderItems.add(product);
			System.out.println("You chose "+product.getName()+".\n");
		}
		return orderItems;
	}
	
	public static void option1() {
		ArrayList<Product> orderItems = new ArrayList<Product>();
		showMenu(); 
		int selected = Integer.parseInt(input("Please select the number of the product that you would like to have"));
		orderItems = findSelectedProduct(selected,orderItems);
		String extra = input("Would you like to have something extra? [y/n]");
		int selected2 = 0;
		if (extra.strip().equals("y")) {
			selected2 = Integer.parseInt(input("Please select the number of the product that you would like to have"));
			orderItems = findSelectedProduct(selected2,orderItems);
		}
		
		String extraIngredients = input("Would you like to remove or add an ingredient from the list? [y/n]");
		if (extraIngredients.strip().equals("y")) {
			String selectedIngs[] = input("Please select the indexes of the ingredients that u would like to have [separated by ;]").strip().split(";");
			for (String i: selectedIngs) {
				int idx = Integer.parseInt(i)-combos.size()-baseMenu.size();
				Ingredient currentIngredient = ingredients.get(idx);
				String addORremove = input("Would you like to add/remove "+currentIngredient.getName()+"? [add/remove]").strip();
				if (addORremove.equals("add")) {
					orderItems.add(restaurant.addIngredient(orderItems.get(0), currentIngredient));
					orderItems.remove(0);
				}
				else if (addORremove.equals("remove")) {
					orderItems.add(restaurant.removeIngredient(orderItems.get(0), currentIngredient));
					orderItems.remove(0);
				}
			}
		}
		String clientname = input("Please introduce your name here");
		String clientaddress = input("Please introduce your address here");
		restaurant.startOrder(orderItems,clientname,clientaddress);
		System.out.println("Thanks, we're sending your food to your location right now!\nWe'll save the bill information in a file, make sure to check it!");
		restaurant.closeAndSaveOrder();
	}
	
	public static void showMenu() {
		String msg = "";
		int count = 0;
		msg += "\nLIST OF COMBOS:\n";
		for (Combo i: combos) {
			msg += "   "+"Combo #"+String.valueOf(count)+" : "+i.getName()+" = "+String.valueOf(i.getPrice())+" | Contains:\n";
			for (MenuProduct j: i.getItemsCombo()) {
				msg+="       "+j.getName()+" "+String.valueOf(j.getPrice())+"\n";
			}
			
			count ++;
		}
		msg += "\nPRODUCTS FROM THE BASIC MENU:\n";
		for (String key: baseMenu.keySet()) {
			msg +="   "+ "Menu #"+String.valueOf(count) + " : " + key + " = " +String.valueOf(baseMenu.get(key).getPrice())+"\n";
			count ++;
		}
		msg += "\nINGREDIENTS TO CHOOSE FROM OR REMOVE:\n";
		for (Ingredient k: ingredients) {
			msg +="   "+ "Ingredient #"+String.valueOf(count) + " : " + k.getName() + " = " +String.valueOf(k.getAditionalCost())+"\n";
			count ++;
		}
		System.out.println(msg);
	}
	
	public static void executeOption(int option) {
		if (option == 0) {
			System.exit(0);
		}
		else if (option == 1) {
			option1();
		}
	}
	
	public static void showOptions() { // NEW
		System.out.println("________\nWelcome!\n"+
							"1. Order food\n"+
							"0. Exit");
		
	}
	
	public static void main(String[] args) {
		combos = restaurant.getCombos();
		baseMenu = restaurant.getBaseMenu();
		ingredients = restaurant.getIngredients();
		
		File ingredientsFile = new File(ingredientsFileDir);
		File menuFile = new File(menuFileDir);
		File combosFile = new File(combosFileDir);
		restaurant.loadInfoRestaurant(ingredientsFile,menuFile,combosFile);
		while(true) {
			showOptions();
			int option = Integer.parseInt(input("Choose an option"));
			executeOption(option);
		}
	}
	
	public static String input(String mensaje)
	{
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
