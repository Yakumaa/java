package Unit2;
//swing is used to cread GUI controls and desktop application. it contains list classes that allows to create different graphical componentsas well as different events
//on top lelvel, container is used which helps to place coponents. in swing the top level container is JFrame. it uses certain features of awt
//following package should be imported
//javax.swing.*;-> swing controls
//java.awt.*;-> awt controls
//java.awt.event.*;-> awt events

import java.awt.FlowLayout;
import javax.swing.*;

class Form extends JFrame{  //inheritng properties of JFrame
  //create instance variables of controls
  JLabel l1, l2, l3, l4, l5, l6, l7;
  JTextField t1;
  JPasswordField p1, p2;
  JRadioButton r1, r2;
  JCheckBox c1, c2, c3;
  JComboBox cb1;
  JButton b1;

  //create object of each control
  public void setForm(){
    l1 = new JLabel("Username");
    l2 = new JLabel("Password");
    l3 = new JLabel("RePassword");
    l4 = new JLabel("Gender");
    l5 = new JLabel("Course");
    l6 = new JLabel("Country");
    l7 = new JLabel("Result");
    t1 = new JTextField(20);
    p1 = new JPasswordField(20);
    p2 = new JPasswordField(20);
    r1 = new JRadioButton("Male");
    r2 = new JRadioButton("Female");
    //radio button should be place in Buttongroup
    ButtonGroup bg = new ButtonGroup();
    bg.add(r1);
    bg.add(r2);
    c1 = new JCheckBox("C"); 
    c2 = new JCheckBox("C++");
    c3 = new JCheckBox("Java");
    //combobox: list of item shoud be created
    String[] item = {"India", "USA", "UK", "Canada"};
    cb1 = new JComboBox(item);
    b1 = new JButton("Submit");
    //add componentes into JFrame window
    add(l1);add(t1);
    add(l2);add(p1);
    add(l3);add(p2);
    add(l4);add(r1);add(r2);
    add(l5);add(c1);add(c2);add(c3);
    add(l6);add(cb1);
    add(b1);add(l7);
    //setting properties of JFrame
    setVisible(true);
    setSize(400, 400);
    setLayout(new FlowLayout());
    //if window is closed, program should be terminated
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

public class SwingControlDemo {
  public static void main(String[] args) {
    Form f = new Form();
    f.setForm();
  }
}
