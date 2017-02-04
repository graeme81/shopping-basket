package example.codeclan.com.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 03/02/2017.
 */
public class ItemTest {

    private Item item1;
    private Item item2;

    @Before
    public void before(){
        item1 = new Item("Book", 7.99, 1234,true);
        item2 = new Item("Dvd", 10.99, 2468, false);
    }
    @Test
    public void canGetItemName(){
        assertEquals("Book",item1.getName());
    }

    @Test
    public void canGetItemPrice(){
        assertEquals(7.99,item1.getPrice(),0.01);
    }

    @Test
    public void canGetItemId(){
        assertEquals(1234,item1.getId());
    }

    @Test
    public void canGetBOGOFStatus(){
        assertEquals(true,item1.getBOGOF());
    }

    @Test
    public void canGetAllItem2Details(){
        assertEquals("Dvd", item2.getName());
        assertEquals(10.99, item2.getPrice(), 0.01);
        assertEquals(2468, item2.getId());
        assertEquals(false, item2.getBOGOF());
    }

}