package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClosetTest {
    private Closet testCloset;

    ClothingItem item1 = new ClothingItem("adidas shoes","shoe", "white", 3);
    ClothingItem item2 = new ClothingItem("winter jacket","top", "green", 5);
    ClothingItem item3 = new ClothingItem("joggers","bottom", "black", 2);

    @BeforeEach
    void runBefore() {
        testCloset = new Closet();
    }

    @Test
    void addOneItem() {
        testCloset.addItem(item1);
        assertEquals(1, testCloset.size());
        assertTrue(testCloset.contains(item1));
    }

    @Test
    void addMultipleItems() {
        testCloset.addItem(item1);
        testCloset.addItem(item2);
        testCloset.addItem(item3);
        assertEquals(3, testCloset.size());
        assertTrue(testCloset.contains(item1));
        assertTrue(testCloset.contains(item2));
        assertTrue(testCloset.contains(item3));
    }

    @Test
    void removeItemFromEmptyCloset() {
        testCloset.removeItem(item2);
        assertEquals(0, testCloset.size());
    }

    @Test
    void removeMultipleItemsFromCloset() {
        testCloset.addItem(item1);
        testCloset.addItem(item2);
        testCloset.addItem(item3);
        testCloset.removeItem(item1);
        assertEquals(2, testCloset.size());
        assertFalse(testCloset.contains(item1));
        testCloset.removeItem(item3);
        assertEquals(1, testCloset.size());
        assertFalse(testCloset.contains(item3));
    }

    @Test
    void testGetItems() {
        testCloset.addItem(item1);
        testCloset.addItem(item3);
        assertEquals(2, testCloset.getItems().size());
    }

    @Test
    void testGetItemNames() {
        testCloset.addItem(item1);
        testCloset.addItem(item2);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("adidas shoes");
        expected.add("winter jacket");
        assertEquals(expected, testCloset.getItemNames());
    }
}