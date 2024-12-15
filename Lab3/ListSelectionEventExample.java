package Lab3;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListSelectionEventExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("List Selection Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a list model and populate it with items
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Apple");
        listModel.addElement("Banana");
        listModel.addElement("Cherry");
        listModel.addElement("Date");
        listModel.addElement("Elderberry");

        // Create a JList and set the model
        JList<String> fruitList = new JList<>(listModel);
        fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Single selection mode
        fruitList.setVisibleRowCount(5); // Number of visible rows

        // Add the list to a scroll pane
        JScrollPane scrollPane = new JScrollPane(fruitList);

        // Create a label to display the selected item
        JLabel selectionLabel = new JLabel("Select a fruit from the list", SwingConstants.CENTER);

        // Add a ListSelectionListener to the JList
        fruitList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Only act on the final selection (avoid intermediate events)
                if (!e.getValueIsAdjusting()) {
                    String selectedValue = fruitList.getSelectedValue();
                    if (selectedValue != null) {
                        selectionLabel.setText("Selected: " + selectedValue);
                    } else {
                        selectionLabel.setText("No selection");
                    }
                }
            }
        });

        // Add components to the frame
        frame.add(selectionLabel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
