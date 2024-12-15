package Lab3;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class FocusEventExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Focus Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1, 10, 10));

        // Create text fields to capture focus events
        JTextField textField1 = new JTextField("Click to focus me!");
        JTextField textField2 = new JTextField("Or click to focus me!");
        JTextField textField3 = new JTextField("Another focusable field!");

        // Add FocusListener to each text field
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                source.setBackground(Color.CYAN); // Highlight the field with a color
                source.setText("Focus gained!");
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                source.setBackground(Color.WHITE); // Reset background color
                source.setText("Focus lost!");
            }
        };

        // Attach the FocusListener to all text fields
        textField1.addFocusListener(focusListener);
        textField2.addFocusListener(focusListener);
        textField3.addFocusListener(focusListener);

        // Add text fields to the frame
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
