package modelo;

public class MenuProduct implements Product{
	
	private String name;
	private double basePrice; // INT TO DOUBLE

	public MenuProduct(String name, int price) {
		this.name = name;
		this.basePrice = price;
	}

	public double getPrice() {return basePrice;}

	public String getName() {return name;}

	public String generateBillText() {
		String bill = name + " : " + String.valueOf(basePrice);
		return bill;
	}

}
