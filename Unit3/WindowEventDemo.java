package Unit3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class WindowEg{
  JFrame f;
  public void setWindow(){
    f = new JFrame();
    f.setVisible(true);
    f.setSize(200, 200);
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(3);
    f.addWindowListener(new WindowListener() {
      @Override
      public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened");
      }
      @Override
      public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
      }
      @Override
      public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");
      }
      @Override
      public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified");
      }
      @Override
      public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified");
      }
      @Override
      public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");
      }
      @Override
      public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");
      }
    });
  }
}
public class WindowEventDemo {
  public static void main(String[] args) {
    WindowEg w = new WindowEg();
    w.setWindow();
  }
}
