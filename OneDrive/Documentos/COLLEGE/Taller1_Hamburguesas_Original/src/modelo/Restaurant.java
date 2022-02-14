package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Restaurant {
	
	private ArrayList<Order> orders;
	private Order currentOrder;
	private static ArrayList<Ingredient> ingredients;
	private ArrayList<Combo> combos;
	private HashMap<String,MenuProduct> baseMenu;
	
	
	
	public HashMap<String,MenuProduct> getBaseMenu() {return baseMenu;}
	
	public ArrayList<Ingredient> getIngredients() {return ingredients;}
	
	public ArrayList<Combo> getCombos() {return combos;}

	public Restaurant() {
		ingredients = new ArrayList<Ingredient>();
		orders = new ArrayList<Order>();
		combos = new ArrayList<Combo>();
		baseMenu = new HashMap<String,MenuProduct>();
	}
	
	public void startOrder(ArrayList<Product> orderItems, String clientname, String clientaddress) {
		Order order = new Order(clientname,clientaddress);
		for(Product i: orderItems) {
			order.addProduct(i);
		}
		orders.add(order);
		order.setOrderId(orders.size()-1);
		currentOrder = order;
	}
	
	public void closeAndSaveOrder() {
		File billFile = new File("order_"+String.valueOf(currentOrder.getIdOrder())+".txt");
		boolean result;  
		try   
		{  
			result = billFile.createNewFile();  //creates a new file  
			if(result)      // test if successfully created a new file  
			{  
				System.out.println("\nFile created "+billFile.getCanonicalPath()); //returns the path string  
			} else {  
				System.out.println("\nFile already exist at location: "+billFile.getCanonicalPath());  
			}  
		}   
		catch (IOException e) {  
			e.printStackTrace();    //prints exception if any  
		}         
		currentOrder.keepBill(billFile);
		currentOrder = null;
	}
	
	public Order getCurrentOrder() {return currentOrder;}
	
	public AdjustedProduct addIngredient(Product product,Ingredient ingredient) {
		AdjustedProduct adjusted = new AdjustedProduct(product);
		adjusted.addIngredient(ingredient);
		return adjusted;
	}
	
	public AdjustedProduct removeIngredient(Product product,Ingredient ingredient) {
		AdjustedProduct adjusted = new AdjustedProduct(product);
		adjusted.removeIngredient(ingredient);
		return adjusted;
	}
	
	public void loadInfoRestaurant(File ingredientsFile,File menuFile, File combosFile) {
		loadIngredients(ingredientsFile);
		loadMenu(menuFile);
		loadCombos(combosFile);
	}
	
	private void loadIngredients(File ingredientsFile) {
		try {
		      Scanner myReader = new Scanner(ingredientsFile);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] elements = data.split(";");
		        String name = elements[0];
		        int price = Integer.parseInt(elements[1]);
		        Ingredient ingredient = new Ingredient(name,price);
		        ingredients.add(ingredient);
		      }
		      myReader.close();
		    } 
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	private void loadMenu(File menuFile) {
		try {
		      Scanner myReader = new Scanner(menuFile);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] elements = data.split(";");
		        String name = elements[0];
		        int price = Integer.parseInt(elements[1]);
		        MenuProduct menuProduct = new MenuProduct(name,price);
		        baseMenu.put(name,menuProduct);
		      }
		      myReader.close();
		    }
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	private void loadCombos(File combosFile) {
		try {
		      Scanner myReader = new Scanner(combosFile);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] elements = data.split(";");
		        String name = elements[0];
		        int discount = Integer.parseInt(elements[1].replace("%",""))/100;
		        Combo combo = new Combo(name,discount);
		        MenuProduct itemcombo1 = baseMenu.get(elements[2]);
		        combo.addItemToCombo(itemcombo1);
		        MenuProduct itemcombo2 = baseMenu.get(elements[3]);
		        combo.addItemToCombo(itemcombo2);
		        MenuProduct itemcombo3 = baseMenu.get(elements[4]);
		        combo.addItemToCombo(itemcombo3);
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
