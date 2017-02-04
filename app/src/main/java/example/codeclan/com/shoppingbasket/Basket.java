package example.codeclan.com.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by user on 03/02/2017.
 */

public class Basket {
    private ArrayList<Item> basket;
    private ArrayList<Integer> bogofList;
    private boolean card;

    public Basket(boolean card){
        this.basket = new ArrayList<>();
        this.bogofList = new ArrayList<>();
        this.card = card;
    }

    public int getSize() {
        return basket.size();
    }
    public void addItem(Item item) {
        basket.add(item);
    }
    public void removeItem() {
        basket.remove(0);
    }
    public void emptyBasket() {
        basket.clear();
    }

    public double getTotal(){

        double total = 0 ;

        total = totalAfterBogof(total);
        total = highPriceDiscount(total);
        total = loyalty(total);

        return total;
    }


    private double totalAfterBogof(double total){
        double reduction = 0;
        int id;

        for (Item item : basket) {

            if (item.getBOGOF()) {
                id = item.getId();
                if (bogofList.size() != 0){

                    for (int i = 0; i < bogofList.size(); i++) {
                        if (id == bogofList.get(i)) {
                            reduction = item.getPrice();
                            bogofList.remove(i);
                        }else bogofList.add(id);
                    }

                }else bogofList.add(id);
            }

            total = total + item.getPrice() - reduction;
            reduction = 0;
        }
        return total;
    }

    private double highPriceDiscount(double total){
        if (total > 20){
            total = total * 0.9;
        }
        return total;
    }

    private double loyalty(double total){
        if (card){
            total =  total*0.98;
        }
        return total;
    }
}
