package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BtnClick extends JFrame{
    JButton b1,b2,b3,b4;
    JTextField t1;
    public void setBtnClick(){
        b1=new JButton("Button 1");
        b2=new JButton("Button 2");
        b3=new JButton("Button 3");
        b4=new JButton("Button 4");
        t1=new JTextField(20);
        b1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               t1.setText("First Button Clicked");
           }
        });
        b2.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               t1.setText("Second Button Clicked");
           }
        });
        b3.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               t1.setText("Third Button Clicked");
           }
        });
        b4.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               t1.setText("Fourth Button Clicked");
           }
        });
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(t1);
        setVisible(true);
        setDefaultCloseOperation(3);
        setSize(500,500);
        setLayout(new FlowLayout());
    }
}
public class ButtonClicks {
    public static void main(String[] args) {
        BtnClick aaa=new BtnClick();
        aaa.setBtnClick();
    }
}

