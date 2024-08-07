package Unit3;
//for every action like clicking button, using mouse
//etc event is generated for every event, listener is used to listen such event. 
//Listener is an interface that contains list of methid to handle event.
// if listeber is used then all the method defined by it should be compulsary used.
//this is known as delegation event memthod
//button->action event
//radio button->action event
//checkbox->action event and item event
//combobox->action event and item event
//list->ListSelectionEvent
//MouseEvent: generated when mouse is clicked, pressed, release, enter, exit
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MouseEg extends JFrame{
  JLabel l1;
  JTextField t1;
  public void setMouse(){
    l1= new JLabel("Result");
    t1 = new JTextField(20);
    //when some mouse action is performed in t1
    t1.addMouseListener(new MouseListener(){
      @Override
      public void mouseClicked(MouseEvent e){
        l1.setText("Mouse Clicked");
      }
      @Override
      public void mousePressed(MouseEvent e){
        l1.setText("Mouse Pressed");
      }
      @Override
      public void mouseReleased(MouseEvent e){
        l1.setText("Mouse Released");
      }
      @Override
      public void mouseEntered(MouseEvent e){
        l1.setText("Mouse Entered in");
      }
      @Override
      public void mouseExited(MouseEvent e){
        l1.setText("Mouse Exited");
      }
    });
    add(l1);add(t1);
    setVisible(true);
    setSize(500,500);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(3);
  }
}
public class MouseEventDemo {
  public static void main(String[] args) {
    MouseEg m = new MouseEg();
    m.setMouse();
  }
}
