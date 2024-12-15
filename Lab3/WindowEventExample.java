package Lab3;

import java.awt.event.*;
import javax.swing.*;

public class WindowEventExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Window Event Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent immediate close

        // Create a JLabel to display window event messages
        JLabel label = new JLabel("Perform actions on the window to see events!", SwingConstants.CENTER);
        frame.add(label);

        // Using Delegation Model: Add a WindowListener directly
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                label.setText("Window Opened!");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to close this window?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    frame.dispose(); // Close the window
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window has been closed.");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                label.setText("Window Minimized!");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window Restored!");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                label.setText("Window Activated!");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window Deactivated!");
            }
        });

        // Using Adapter Class: Add a WindowAdapter
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Adapter: Window Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Adapter: Window Closing");
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}
