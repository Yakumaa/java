package Unit3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CustomWindowAdapter extends WindowAdapter {
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("\nWindow Opened");
    }
}

public class WindowAdapterDemo {
    JFrame f;

    public void setWindow() {
        f = new JFrame();
        f.setVisible(true);
        f.setSize(200, 200);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addWindowListener(new CustomWindowAdapter());
    }

    public static void main(String[] args) {
        WindowAdapterDemo w = new WindowAdapterDemo();
        w.setWindow();
    }
}
