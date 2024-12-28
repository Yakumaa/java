package Unit2;
/*places the content in terms sequence of card
 * one content is placed beside another content
 */
import java.awt.*;
import javax.swing.*;

public class CardLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel(cardLayout);

        panel.add(new JButton("Card 1"), "1");
        panel.add(new JButton("Card 2"), "2");

        cardLayout.show(panel, "2"); // Display first card

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
