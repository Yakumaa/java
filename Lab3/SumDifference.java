package Lab3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Sd extends JFrame{
    JLabel inp1,inp2,result,l1;
    JTextField t1,t2,t3;
    Sd(){
        l1=new JLabel("Mouse click for sum: Mouse Release for Difference");
        inp1=new JLabel("Enter first number: ");
        inp2=new JLabel("Enter second number: ");
        result=new JLabel("Result: ");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        
        add(l1);
        add(inp1);add(t1);
        add(inp2);add(t2);
        add(result);add(t3);
        
        this.addMouseListener(new MouseAdapter(){
           @Override 
           public void mouseClicked(MouseEvent e){
               int in1=Integer.parseInt(t1.getText());
               int in2=Integer.parseInt(t2.getText());
               int sum=in1+in2;
               t3.setText("Sum is: "+sum);
           }
           @Override
           public void mouseReleased(MouseEvent e){
               int in1=Integer.parseInt(t1.getText());
               int in2=Integer.parseInt(t2.getText());
               int diff=in1-in2;
               t3.setText("Difference is: "+diff);
           }
        });
        setSize(400,500);
        setVisible(true);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        
    }
}
public class SumDifference {
    public static void main(String[] args) {
        Sd demo=new Sd();
    }
}

