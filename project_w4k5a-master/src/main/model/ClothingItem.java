package model;

import org.json.JSONObject;

// Represents a clothing item having a type, colour, thickness
public class ClothingItem {
    private String name;         // name of item
    private String type;         // type of item, either a top, bottom, or shoe
    private String colour;       // colour of item
    private int thickness;       // thickness/warmth of item from 1 to 5, 5 being the thickest

    /*
     * REQUIRES: type is either "Top", "Bottom", or "Shoe"
     *           thickness is an integer within [1, 5]
     * EFFECTS: type on the ClothingItem is set to itemType
     *          colour on the ClothingItem is set to itemColour
     *          thickness on the ClothingItem is set to itemThickness
     */
    public ClothingItem(String itemName, String itemType, String itemColour, int itemThickness) {
        this.name = itemName;
        this.type = itemType;
        this.colour = itemColour;
        this.thickness = itemThickness;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColour() {
        return colour;
    }

    public int getThickness() {
        return thickness;
    }

    // method taken from Thingy class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("type", type);
        json.put("colour", colour);
        json.put("thickness", thickness);
        return json;
    }
}
