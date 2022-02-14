package modelo;

public class Ingredient {

	private String name;
	private double aditionalPrice; // INT TO DOUBLE
	
	public Ingredient(String name, int price) {
		this.name = name;
		this.aditionalPrice = price;
	}
	
	public String getName() {return name;}
	
	public double getAditionalCost() {return aditionalPrice;} // INT TO DOBLE

}
