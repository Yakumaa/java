package Unit2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;;

class Ques extends JFrame{
  JLabel l1, l2, l3;
  JTextField t1, t2;
  JButton b1, b2;

  public void setQues(){
    l1 = new JLabel("Enter First Number");
    l2 = new JLabel("Enter Second Number");
    l3 = new JLabel("Result");
    t1 = new JTextField(20);
    t2 = new JTextField(20);
    b1 = new JButton("Add");
    b2 = new JButton("Subtract");
    add(l1); add(t1);
    add(l2); add(t2);
    add(b1); add(b2);add(l3);
    setVisible(true);
    setSize(400, 400);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(3);
    //when buttn is pressed then it will generate event known as action event. 
    //to handle any event listeneer is required so to handle action event action listener is required.
    //action listener is an interface which is implemented by class which is interested in handling action event.
    //it contains actionPerformed method which should be override
    b1.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        int c = a + b;
        l3.setText("Result is: "+c);

        //TODO: Add code to subtract the two numbers
        
      }
    });
  }
}
public class QuestionDemo {
  public static void main(String[] args) {
    Ques q = new Ques();
    q.setQues();
  }
}
