/*sets the content in form of rectangular grid but can specify how many cell to separate for each component
and can also specify on which coordintae content is to be class
 */
package  Unit2;
import java.awt.*;
import javax.swing.*;
class Grids extends JFrame{
    JButton b1,b2,b3;
    public void setGrid(){
        b1 = new JButton("leftbutton");
        b2 = new JButton("rightbutton");
        b3 = new JButton("downbutton");
        //creating object of gridbaglayout
        GridBagLayout gbl = new GridBagLayout();
        //to adjust the coorindinate and other setting of component gridbag constraints is used
        GridBagConstraints gbc = new GridBagConstraints();
        setVisible(true);
        setSize(500,500);
        setLayout(gbl);
        setDefaultCloseOperation(3);
        //adding first button on coordinate 0,0
        gbc.gridx = 0;//x-coordinate
        gbc.gridy = 0;//y-coordinate
        //to set orientation of component
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b1,gbc);//adding comp ton window
        //with constraints
        //for second button->1,0
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b2,gbc);
        //for last button ->0,1 and giving 2 cell
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;// allocating 2 cell
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b3,gbc);

       

    }
}
public class GridBagLayoutDemo {
    public static void main(String[] args) {
        Grids g = new Grids();
        g.setGrid();
    }
}