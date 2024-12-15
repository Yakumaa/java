package Lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Mouse Event Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel to listen for mouse events
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        // Create a label to display mouse actions
        JLabel label = new JLabel("Perform a mouse action inside the panel", SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        // Using Delegation Model (MouseListener)
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse pressed at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse released at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse entered the panel");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse exited the panel");
            }
        });

        // Using Adapter Class (MouseAdapter)
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                label.setText("Mouse moved at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                label.setText("Mouse dragged at (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
