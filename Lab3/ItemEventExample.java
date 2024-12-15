package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Item Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Create checkboxes
        JCheckBox checkBox1 = new JCheckBox("Java");
        JCheckBox checkBox2 = new JCheckBox("Python");
        JCheckBox checkBox3 = new JCheckBox("C++");

        // Create a label to display selected options
        JLabel resultLabel = new JLabel("Selected: None");

        // ItemListener to handle checkbox state changes
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                StringBuilder selectedItems = new StringBuilder("Selected: ");
                
                // Check which checkboxes are selected
                if (checkBox1.isSelected()) {
                    selectedItems.append("Java ");
                }
                if (checkBox2.isSelected()) {
                    selectedItems.append("Python ");
                }
                if (checkBox3.isSelected()) {
                    selectedItems.append("C++ ");
                }

                // Update the label
                if (selectedItems.toString().equals("Selected: ")) {
                    selectedItems.append("None");
                }
                resultLabel.setText(selectedItems.toString());
            }
        };

        // Add ItemListener to the checkboxes
        checkBox1.addItemListener(itemListener);
        checkBox2.addItemListener(itemListener);
        checkBox3.addItemListener(itemListener);

        // Add components to the frame
        frame.add(checkBox1);
        frame.add(checkBox2);
        frame.add(checkBox3);
        frame.add(resultLabel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
