package Lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Key Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a text area to capture key events
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setFocusable(true); // Ensure the text area can capture key events

        // Create a label to display key actions
        JLabel label = new JLabel("Type something...", SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        // Using Delegation Model (KeyListener)
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        // Using Adapter Class (KeyAdapter)
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    label.setText("Backspace key pressed!");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    label.setText("Enter key released!");
                }
            }
        });

        // Add the text area to the frame
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}

