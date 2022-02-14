package modelo;

import java.util.ArrayList;

public class Combo {
	
	private double discount;
	private String comboName;
	private ArrayList<MenuProduct> itemsCombo;

	public Combo(String name, double discount) {
		this.discount = discount;
		this.comboName = name;
		this.itemsCombo = new ArrayList<MenuProduct>();
	}

	public void addItemToCombo(MenuProduct itemCombo) {this.itemsCombo.add(itemCombo);}

	public double getPrice() { // INT TO DOUBLE
		double sum = 0;
		for (MenuProduct i: itemsCombo) {
			sum += i.getPrice();
		}
		return sum*(1-discount);
	}
	
	public String generateBillText() {
		String bill = "";
		bill += comboName +":\n";
		for (Product i: this.itemsCombo) {
			bill += i.generateBillText();
		}
		return bill;
	}
	
	public String getName() {return comboName;}
	
	public ArrayList<MenuProduct> getItemsCombo() {return itemsCombo;}
}
