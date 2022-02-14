package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {

	private int numberOrders = 0;
	private int idOrder;
	private String clientName;
	private String clientAdress;
	private ArrayList<Product> orderItems;
	private double IVA = 0.19;

	public Order(String clientname, String clientadress) {
		numberOrders ++;
		this.clientName = clientname;
		this.clientAdress = clientadress;
		this.orderItems = new ArrayList<Product>();
	}
	
	public ArrayList<Product> getOrderItems(){
		return orderItems;
	}

	public int getIdOrder() {return this.idOrder;}
	public void addProduct(Product newItem) {this.numberOrders += 1;this.orderItems.add(newItem);}

	public int getNumberOrders() {return this.numberOrders;}
	
	private double getNetPriceOfOrder() { // CHANGED INT TO DOUBLE RETURN TYPE
		double sum = 0;
		for (Product i : this.orderItems ) {
			sum += i.getPrice();
		}
		return sum;
	}
	private double getTotalPriceOfOrder() { // CHANGED INT TO DOUBLE RETURN TYPE
		return getNetPriceOfOrder()*(1+IVA);
	}
	private double getIVAPriceOfOrder() { // CHANGED INT TO DOUBLE RETURN TYPE
		return getNetPriceOfOrder()*IVA;
	}
	
	public void setOrderId(int id) {idOrder = id;}
	
	private String generateBillText() {
		String bill = "";
		bill += "RECIPIENT: "+this.clientName+"\nADDRES OF RECIPIENT: "+this.clientAdress+"\nPRODUCTS: \n";
		int count = 1;
		for (Product i: this.orderItems) {
			bill += "     #"+String.valueOf(count)+"  "+i.generateBillText()+"\n";
			count ++;
		}
		bill += "TOTAL: "+this.getTotalPriceOfOrder()+"\nNET PRICE: "+this.getNetPriceOfOrder()+"\nIVA: "+this.getIVAPriceOfOrder()+"\nCALORIES: "+String.valueOf(300.56*this.orderItems.size());
		return bill;
	}
	
	public void keepBill(File bill) {
		String toWrite = this.generateBillText();
		try {
		      FileWriter myWriter = new FileWriter(bill.getName());
		      myWriter.write(toWrite);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred while trying to save the file.");
		      e.printStackTrace();
		    }
	}
}
