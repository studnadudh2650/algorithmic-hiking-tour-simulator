package th.rosenheim.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AppTest {

    @Test
    void helloWorldTest() {
        String expected = "Hello World!";
        String actual = "Hello World!";
        assertEquals(expected, actual);
    }

    @Test
    void testAddItemStoresInBackpack() {
        Participant p = new Participant("Test", 20);
        Item item = new Item("TestItem", 2.5);
        p.addItem(item);

        List<Item> backpack = p.getBackpack();
        assertEquals(1, backpack.size());
        assertEquals("TestItem", backpack.get(0).getName());
    }

    @Test
    void testGetTotalWeight() {
        Participant p = new Participant("Test", 30);
        p.addItem(new Item("Tent", 3.0));
        p.addItem(new Item("Water", 1.5));

        double totalWeight = p.getTotalWeight();
        assertEquals(4.5, totalWeight, 0.001);
    }
}