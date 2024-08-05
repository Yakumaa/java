package Unit2;
/*places the content in terms sequence of card
 * one content is placed beside another content
 */
import java.awt.*;
import javax.swing.*;
class Cards extends JFrame{
    JButton b1,b2,b3;
    public void setCard(){
        b1= new JButton("First");
        b2 = new JButton("Second");
        b3 = new JButton("Third");
        //subwindow: to change the content of window
        JPanel p1 = new JPanel();
        p1.add(b1,"but1");p1.add(b2,"but2");p1.add(b3,"but3");
        CardLayout c = new CardLayout();
        p1.setLayout(c);
        add(p1);//adding pannel to window
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(3);
        //showing second component
        c.next(p1);
    }
}
public class CardLayoutDemo {
    public static void main(String[] args) {
        Cards c = new Cards();
        c.setCard();
    }
    
}