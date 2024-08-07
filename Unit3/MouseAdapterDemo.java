package Unit3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MAdapter extends JFrame{
  JLabel l1;
  JTextArea t1;
  public void setMAdapter(){
    l1 = new JLabel("Result");
    t1 = new JTextArea(20,20);
    t1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        l1.setText("Mouse Entered");
      }
    });
    add(l1);add(t1);
    setVisible(true);
    setSize(500,500);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(3);
  }
}
public class MouseAdapterDemo {
  public static void main(String[] args) {
    MAdapter m = new MAdapter();
    m.setMAdapter();

  }
}
