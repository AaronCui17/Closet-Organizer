package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// Represents a closet having a list of ClothingItems
public class Closet {
    private ArrayList<ClothingItem> items;  // list of clothing items in the closet

    public Closet() {
        items = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds item to the list of items in the closet and logs the event
     */
    public void addItem(ClothingItem item) {
        items.add(item);
        EventLog.getInstance().logEvent(new Event("Added " + item.getName() + " to your closet."));
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds item to the list of items in the closet without logging the event
     */
    public void addItemForLoading(ClothingItem item) {
        items.add(item);
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes item from the list of items in the closet and logs the event, do nothing if item not in closet
     */
    public void removeItem(ClothingItem item) {
        if (items.contains(item)) {
            items.remove(item);
        }
        EventLog.getInstance().logEvent(new Event("Removed " + item.getName() + " from your closet."));
    }

    public ArrayList<ClothingItem> getItems() {
        return items;
    }

    public int size() {
        return items.size();
    }

    public boolean contains(ClothingItem item) {
        return items.contains(item);
    }

    // method taken from WorkRoom class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("items", itemsToJson());
        return json;
    }

    // method taken from WorkRoom class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (ClothingItem t : items) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns a list of names of items in closet
    public ArrayList<String> getItemNames() {
        ArrayList<String> stringList = new ArrayList<String>();
        for (ClothingItem item : items) {
            stringList.add(item.getName());
        }
        return stringList;
    }
}
