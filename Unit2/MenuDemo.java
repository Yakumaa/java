package Unit2;

import java.awt.*;
import javax.swing.*;

class Menus extends JFrame{
  JMenuBar mb;
  JMenu m1, m2, m3;

  public void setMenu() {
    mb = new JMenuBar();
    m1 = new JMenu("File");
    //for shortcut mnemonic is used
    m1.setMnemonic('f');
    //creating menu item for menu m1
    JMenuItem mi1 = new JMenuItem("New", 'n');
    JMenuItem mi2 = new JMenuItem("Open", 'o');
    JMenuItem mi3 = new JMenuItem("Save", 's');
    //adding menu items into menu m1
    m1.add(mi1);m1.add(mi2);
    m1.add(mi3);
    //addming menu m1 into menubar
    mb.add(m1);
    //for menu m2 -> add radioButton menu item
    m2 = new JMenu("Edit");
    // adding readio button item 
    JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("Cut");
    JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Copy");
    JRadioButtonMenuItem rb3 = new JRadioButtonMenuItem("Paste");
    //adding radio button items into menu m2
    m2.add(rb1);m2.add(rb2);m2.add(rb3);
    //adding menu m2 into menubar
    mb.add(m2);
    //for menu m3 -> add checkbox menu item
    m3 = new JMenu("View");
    //adding checkbox menu item
    JCheckBoxMenuItem cb1 = new JCheckBoxMenuItem("Zoom in");
    JCheckBoxMenuItem cb2 = new JCheckBoxMenuItem("Zoom out");
    //adding checkbox menu items into menu m3
    m3.add(cb1);m3.add(cb2);
    //adding menu m3 into menubar
    mb.add(m3);
    //adding menubar into JFrame
    add(mb);
    setVisible(true);
    setSize(500, 500);
    setLayout(new FlowLayout());
    
  }
}

public class MenuDemo {
  public static void main(String[] args) {
    Menus m = new Menus();
    m.setMenu();
  }
}