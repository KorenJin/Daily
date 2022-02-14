package modelo;

public class Bebida implements Product{

    private double price;
    private String name;

    public Bebida(String name,double price){
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String generateBillText() {
        String msg = "   " + this.name + " = " + String.valueOf(this.price)+"\n";
        return msg;
    }
}
