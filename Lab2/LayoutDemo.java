package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LayDemo {
    JFrame nullLay=new JFrame("Null Layout");
    JFrame flowLay=new JFrame("Flow Layout");
    JFrame cardLay=new JFrame("Card Layout");
    JFrame borderLay=new JFrame("Border Layout");
    JFrame gridLay=new JFrame("Grid Layout");
    JFrame gridBagLay=new JFrame("GridBag Layout");
    JFrame groupLay=new JFrame("Group Layout");
    
    JButton b1,b2,b3,b4,b5;
    JTextArea t1;
    public void setNull(){
        b1=new JButton("Button 1");
        b1.setBounds(0,60,100,50);
        b2=new JButton("Button 2");
        b2.setBounds(60,0,100,50);
        b3=new JButton("Button 3");
        b3.setBounds(100,100,100,50);
        b4=new JButton("Button 4");
        b4.setBounds(150,0,100,50);
        b5=new JButton("Button 5");
        b5.setBounds(0,180,100,50);
        nullLay.add(b1);
        nullLay.add(b2);
        nullLay.add(b3);
        nullLay.add(b4);
        nullLay.add(b5);
        nullLay.setLayout(null);
        nullLay.setDefaultCloseOperation(3);
        nullLay.setVisible(true);
        nullLay.setSize(400,400);
    }
    public void setFlow(){
        b1=new JButton("Button 1");
        b2=new JButton("Button 2");
        b3=new JButton("Button 3");
        b4=new JButton("Button 4");
        b5=new JButton("Button 5");
        flowLay.add(b1);
        flowLay.add(b2);
        flowLay.add(b3);
        flowLay.add(b4);
        flowLay.add(b5);
        flowLay.setLayout(new FlowLayout());
        flowLay.setDefaultCloseOperation(3);
        flowLay.setVisible(true);
        flowLay.setSize(400,400);
    }
    
    public void setCards(){
        b1=new JButton("Card 1");
        b2=new JButton("Card 2");
        b3=new JButton("Card 3");
        JPanel p1=new JPanel();
        p1.add(b1,"but1");
        p1.add(b2,"but2");
        p1.add(b3,"but3");
        CardLayout c1=new CardLayout();
        p1.setLayout(c1);
        cardLay.add(p1);
        cardLay.setSize(200,200);
        cardLay.setDefaultCloseOperation(3);
        cardLay.setVisible(true);
        b1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               c1.next(p1);
           }
        });
    }
    
    public void setBorderLay(){
        borderLay.setLayout(new BorderLayout());
       b1=new JButton("North");
        b2=new JButton("South");
        b3=new JButton("East");
        b4=new JButton("West");
        t1=new JTextArea(20,20);
        borderLay.add(b1,BorderLayout.NORTH);
        borderLay.add(b2,BorderLayout.SOUTH);
        borderLay.add(b3,BorderLayout.EAST);
        borderLay.add(b4,BorderLayout.WEST);
        borderLay.add(t1,BorderLayout.CENTER);
        borderLay.setDefaultCloseOperation(3);
        borderLay.setVisible(true);
        borderLay.setSize(300,300);
    }
     public void setGrid(){
        b1=new JButton("Button 1");
        b2=new JButton("Button 2");
        b3=new JButton("Button 3");
        b4=new JButton("Button 4");
        b5=new JButton("Button 5");
        gridLay.add(b1);
        gridLay.add(b2);
        gridLay.add(b3);
        gridLay.add(b4);
        gridLay.add(b5);
        gridLay.setLayout(new GridLayout(3,3));
        gridLay.setDefaultCloseOperation(3);
        gridLay.setVisible(true);
        gridLay.setSize(300,300);
    }
      public void setGridBag(){
       b1=new JButton("BTN 1");
       b2=new JButton("BTN 2");
       b3=new JButton("BTN 3");
       GridBagLayout gb=new GridBagLayout();
       GridBagConstraints gbc=new GridBagConstraints();
       gridBagLay.setVisible(true);
       gridBagLay.setDefaultCloseOperation(3);
       gridBagLay.setSize(300,300);
       gridBagLay.setLayout(gb);
       gbc.gridx=0;
       gbc.gridy=0;
       gbc.fill=GridBagConstraints.HORIZONTAL;
       gridBagLay.add(b1,gbc);
       gbc.gridx=1;
       gbc.gridy=0;
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gridBagLay.add(b2,gbc);
       gbc.gridx=0;
       gbc.gridy=1;
       gbc.gridwidth=2;//to merge two cell
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gridBagLay.add(b3,gbc);
    }
    public void setGroupLayout() {
    b1 = new JButton("Button 1");
    b2 = new JButton("Button 2");
    b3 = new JButton("Button 3");
    b4 = new JButton("Button 4");
    b5 = new JButton("Button 5");
    JPanel gridLay = new JPanel();
    GroupLayout layout = new GroupLayout(gridLay);
    gridLay.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(b1)
                .addComponent(b2)
                .addComponent(b5))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(b3)
                .addComponent(b4))
    );
    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(b1)
                .addComponent(b3))
            .addComponent(b2)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(b4)
                .addComponent(b5))
    );
    groupLay.setDefaultCloseOperation(3);
    groupLay.setVisible(true);
    groupLay.setSize(300, 300);
    groupLay.add(gridLay);
}
}
public class LayoutDemo {
    public static void main(String[] args) {
        LayDemo demo=new LayDemo();
        demo.setNull();
        demo.setFlow();
        demo.setBorderLay();
        demo.setCards();
        demo.setGrid();
        demo.setGridBag();
        demo.setGroupLayout();
    }
}
