package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClothingItemTest {
    private ClothingItem testItem1;
    private ClothingItem testItem2;

    @BeforeEach
    void runBefore() {
        testItem1 = new ClothingItem("white t-shirt", "top", "white", 1);
        testItem2 = new ClothingItem("jeans", "bottom", "blue", 3);
    }

    @Test
    void testConstructor() {
        assertEquals("white t-shirt", testItem1.getName());
        assertEquals("top", testItem1.getType());
        assertEquals("white", testItem1.getColour());
        assertEquals(1, testItem1.getThickness());
        assertEquals("jeans", testItem2.getName());
        assertEquals("bottom", testItem2.getType());
        assertEquals("blue", testItem2.getColour());
        assertEquals(3, testItem2.getThickness());
    }

    @Test
    void testGetName() {
        assertEquals("white t-shirt", testItem1.getName());
        assertEquals("jeans", testItem2.getName());
    }

    @Test
    void testGetType() {
        assertEquals("top", testItem1.getType());
        assertEquals("bottom", testItem2.getType());
    }

    @Test
    void testGetColour() {
        assertEquals("white", testItem1.getColour());
        assertEquals("blue", testItem2.getColour());
    }

    @Test
    void testGetThickness() {
        assertEquals(1, testItem1.getThickness());
        assertEquals(3, testItem2.getThickness());
    }
}