package Lab2;

import java.awt.*;
import javax.swing.*;
class OtherEg extends JFrame{
    JTextField t1;
    JComboBox cb1;
    JTable tb1;
     public void setOther(){
        String[] data={"java","c","c++"};
        cb1=new JComboBox(data);
        JPanel p1=new JPanel();
        p1.add(cb1);
        String[] col={"id","name","faculty"};
        String [][] data1={{"1","Sam","csit"}
                ,{"2","Pam","CIST"}
                ,{"3","Ham","BCA"}
                ,{"4","Dam","bba"}
                ,{"5","Jam","iST"}
                ,{"6","Oam","CIST"}
                ,{"2","Yam","CIST"}
                ,{"3","Lam","BCA"}
                ,{"4","Mam","bba"}
                ,{"5","Nam","iST"}
                ,{"6","Bam","CIST"}
                };
        tb1=new JTable(data1,col);
        tb1.setPreferredScrollableViewportSize(new Dimension(100,100));
        add(p1);
        add(tb1);
        setVisible(true);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        setSize(500,500);
    }
}

public class JTable_JComboBox {
  public static void main(String[] args) {
    OtherEg as=new OtherEg();
    as.setOther();
}

}
