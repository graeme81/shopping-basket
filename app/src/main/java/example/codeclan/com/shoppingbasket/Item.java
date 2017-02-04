package example.codeclan.com.shoppingbasket;

/**
 * Created by user on 03/02/2017.
 */

public class Item {
    private String name;
    private double price;
    private int id;
    private boolean BOGOF;

    public Item(String name,double price, int id, Boolean BOGOF){
        this.name = name;
        this.price = price;
        this.id = id;
        this.BOGOF = BOGOF;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public boolean getBOGOF() {
        return BOGOF;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
