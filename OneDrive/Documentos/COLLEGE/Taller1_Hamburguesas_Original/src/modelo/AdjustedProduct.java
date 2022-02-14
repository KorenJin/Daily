package modelo;

import java.util.ArrayList;

public class AdjustedProduct implements Product{ 
	
	private ArrayList<Ingredient> added;
	private ArrayList<Ingredient> removed;
	
	private String name; // CHANGED
	private double price; // CHANGED

	public AdjustedProduct(Product base) {
		this.name = base.getName();
		this.price = base.getPrice();
		this.added = new ArrayList<Ingredient>();
		this.removed = new ArrayList<Ingredient>();
	}
	
	@Override
	public String getName() {return name;}

	@Override
	public double getPrice() {return price;}

	@Override
	public String generateBillText() {
		String bill =this.name+"= "+String.valueOf(this.price)+" :\n";
		for (Ingredient i: added) {
			bill += "           ADDED: "+i.getName()+" "+String.valueOf(i.getAditionalCost())+"\n";
			}
		for (Ingredient i: removed) {
			bill += "           REMOVED: "+i.getName()+" "+String.valueOf((-1)*(i.getAditionalCost()))+"\n";
			}
		return bill;
	}
		
	// CHANGED :
	
	public void addIngredient(Ingredient ingredient) {
		added.add(ingredient);
		price += ingredient.getAditionalCost();
	}
	
	public void removeIngredient(Ingredient ingredient) {
		removed.add(ingredient);
		price -= ingredient.getAditionalCost();
	}
		
}

