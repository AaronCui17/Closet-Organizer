package persistence;

import model.Closet;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    // method taken from JsonReaderTest class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Closet c = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // method taken from JsonReaderTest class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCloset.json");
        try {
            Closet c = reader.read();
            assertEquals(0, c.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // method taken from JsonReaderTest class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCloset.json");
        try {
            Closet c = reader.read();
            assertEquals(2, c.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}