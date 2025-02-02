package persistence;

import model.Closet;
import model.ClothingItem;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {

    // method taken from JsonWriterTest class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Test
    void testWriterInvalidFile() {
        try {
            Closet c = new Closet();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    // method taken from JsonWriterTest class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Test
    void testWriterEmptyCloset() {
        try {
            Closet c = new Closet();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCloset.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCloset.json");
            c = reader.read();
            assertEquals(0, c.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    // method taken from JsonWriterTest class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Test
    void testWriterGeneralCloset() {
        try {
            Closet c = new Closet();
            ClothingItem cI1 = new ClothingItem("hoodie", "top", "purple", 3);
            ClothingItem cI2 = new ClothingItem("joggers", "bottom", "black", 3);
            c.addItem(cI1);
            c.addItem(cI2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCloset.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCloset.json");
            c = reader.read();
            assertEquals(2, c.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
