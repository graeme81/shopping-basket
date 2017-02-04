package example.codeclan.com.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 03/02/2017.
 */
public class BasketTest {
    private Basket basket1, basket2;
    private Item item1, item2, item3;

    @Before
    public void before(){
        basket1 = new Basket(true);     // has a loyalty card
        basket2 = new Basket(false);    // has no loyalty card
        item1 = new Item("Cd", 10.99, 1234, true);
        item2 = new Item("Dvd", 7.99, 2468, false);
        item3 = new Item("Book", 8.99, 3691, true);
    }

    @Test
    public void basketStartsOutEmpty(){
        assertEquals(0,basket1.getSize());
    }

    @Test
    public void canAddItemToBasket(){
        basket1.addItem(item1);
        assertEquals(1,basket1.getSize());
    }

    @Test
    public void canRemoveItemFormBasket(){
        fillBasket();
        basket1.removeItem();
        assertEquals(2,basket1.getSize());
    }

    @Test
    public void canEmptyBasket(){
        fillBasket();
        assertEquals(3,basket1.getSize());
        basket1.emptyBasket();
        assertEquals(0,basket1.getSize());
    }

    @Test
    public void canCalculateTotalPriceOfBasket(){
        fillBasket2();
        assertEquals(18.98,basket2.getTotal(),0.01);
    }

    @Test
    public void canCalculateForBOGOF(){
        basket2.addItem(item1);
        basket2.addItem(item3);
        basket2.addItem(item1);
        basket2.addItem(item3);
        assertEquals(19.98, basket2.getTotal(),0.01);
        assertEquals(4, basket2.getSize());
    }

    @Test
    public void canCalculateForHighPriceDiscount(){
        fillBasket2();
        fillBasket2();
        assertEquals(32.36,basket2.getTotal(),0.01);
    }

    @Test
    public void canCalculateLoyalytCardDiscount(){
        fillBasket();
        fillBasket();
        assertEquals(31.72,basket1.getTotal(),0.01);
    }







    private void fillBasket(){
        basket1.addItem(item1);
        basket1.addItem(item2);
        basket1.addItem(item3);
    }

    private void fillBasket2(){
        basket2.addItem(item1);
        basket2.addItem(item2);
        basket2.addItem(item3);
    }


}