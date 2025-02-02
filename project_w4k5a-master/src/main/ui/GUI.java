package ui;

import model.Closet;
import model.ClothingItem;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Graphical user interface for the closet app
public class GUI implements ActionListener {

    private static final String JSON_STORE = "./data/closet.json";
    private Closet closet = new Closet();
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);

    private JFrame frame;

    private JPanel buttonPanel;
    private JPanel persistencePanel;
    private JPanel mainPanel;

    private JButton saveButton;
    private JButton loadButton;
    private JButton addButton;
    private JButton removeButton;

    private JTextField itemName;
    private JTextField itemType;
    private JTextField itemColour;
    private JTextField itemThickness;

    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel colourLabel;
    private JLabel thicknessLabel;

    private JList list;
    private DefaultListModel listModel;

    // MODIFIES: this
    // EFFECTS: sets up all GUI related fields
    public GUI() {

        setupButtons();
        setupInputs();
        setupList();
        setupButtonPanel();
        setupPersistencePanel();
        setupMainPanel();
        setupFrame();
    }

    // MODIFIES: this
    // EFFECTS: sets up buttons
    private void setupButtons() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("save");

        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        loadButton.setActionCommand("load");

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setActionCommand("add");

        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        removeButton.setActionCommand("remove");
    }

    // MODIFIES: this
    // EFFECTS: sets up text fields and labels
    private void setupInputs() {
        itemName = new JTextField();
        itemType = new JTextField();
        itemColour = new JTextField();
        itemThickness = new JTextField();

        nameLabel = new JLabel("Name");
        typeLabel = new JLabel("Type");
        colourLabel = new JLabel("Colour");
        thicknessLabel = new JLabel("Thickness");
    }

    // MODIFIES: this
    // EFFECTS: sets up JList requirements
    private void setupList() {
        listModel = new DefaultListModel();
        list = new JList(listModel);
    }

    // MODIFIES: this
    // EFFECTS: sets up add item and remove item panel
    private void setupButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30,30));
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.add(removeButton);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPanel.add(nameLabel);
        buttonPanel.add(itemName);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPanel.add(typeLabel);
        buttonPanel.add(itemType);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPanel.add(colourLabel);
        buttonPanel.add(itemColour);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPanel.add(thicknessLabel);
        buttonPanel.add(itemThickness);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPanel.add(addButton);
    }

    // MODIFIES: this
    // EFFECTS: sets up save and load button pannel
    private void setupPersistencePanel() {
        persistencePanel = new JPanel();
        persistencePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30,30));
        persistencePanel.setLayout(new GridLayout());
        persistencePanel.add(saveButton);
        persistencePanel.add(loadButton);
    }

    // MODIFIES: this
    // EFFECTS: sets up main panel
    private void setupMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30,30));
        mainPanel.setLayout(new GridLayout());
        mainPanel.add(list);
    }

    // MODIFIES: this
    // EFFECTS: sets up frame
    private void setupFrame() {
        frame = new JFrame();
        frame.add(persistencePanel, BorderLayout.PAGE_START);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Closet");
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                for (model.Event event : EventLog.getInstance()) {
                    System.out.println(event.toString());
                    System.out.println("");
                }
            }
        });
    }

    // EFFECTS: handles events of button clicks
    public void actionPerformed(ActionEvent e) {
        if ("save".equals(e.getActionCommand())) {
            saveCloset();
        } else if ("load".equals(e.getActionCommand())) {
            loadCloset();
            loadJListElement();
        } else if ("add".equals(e.getActionCommand())) {
            doAddItem();
            addJListElement();
        } else if ("remove".equals(e.getActionCommand())) {
            doRemoveItem();
        }
    }

    // EFFECTS: saves the workroom to file
    private void saveCloset() {
        try {
            jsonWriter.open();
            jsonWriter.write(closet);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
        createPopup();
    }

    // EFFECTS: creates a popup of a cat image with text when program is saved
    private void createPopup() {

        JLabel message = new JLabel("File saved!");

        ImageIcon catImage = new ImageIcon("cat.jpg");
        JLabel displayLabel = new JLabel();
        displayLabel.setIcon(catImage);

        JPanel popupPanel = new JPanel();
        popupPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30,30));
        popupPanel.setLayout(new GridLayout());
        popupPanel.add(message);
        popupPanel.add(displayLabel);

        JFrame popup = new JFrame();
        popup.add(popupPanel, BorderLayout.CENTER);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setTitle("Yayy");
        popup.pack();
        popup.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadCloset() {
        try {
            closet = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the names of the ClothingItems in Closet to a list model when loading data
    private void loadJListElement() {
        for (String name : closet.getItemNames()) {
            listModel.addElement(name);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds given item to the closet
    private void doAddItem() {
        String name = itemName.getText();
        String type = itemType.getText();
        String colour = itemColour.getText();
        String stringThickness = itemThickness.getText();
        int thickness = Integer.parseInt(stringThickness);

        ClothingItem item = new ClothingItem(name, type, colour, thickness);
        closet.addItem(item);
    }

    // MODIFIES: this
    // EFFECTS: adds the name of the newly added ClothingItem in Closet to a list model
    private void addJListElement() {
        listModel.addElement(itemName.getText());
    }

    // MODIFIES: this
    // EFFECTS: removes given item from the closet
    private void doRemoveItem() {
        int index = list.getSelectedIndex();
        String name = listModel.getElementAt(index).toString();
        ClothingItem itemToRemove = new ClothingItem("", "", "", 1);
        for (ClothingItem i : closet.getItems()) {
            if (i.getName().equals(name)) {
                itemToRemove = i;
            }
        }
        listModel.remove(index);
        closet.removeItem(itemToRemove);
    }
}
