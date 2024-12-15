package Lab2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
class Menus extends JFrame{
    JMenuBar mb;
    JMenu m1,m2,m3,m4;
    JSplitPane sp1;
    public void setMenu(){
        mb=new JMenuBar();
        m1=new JMenu("File");
        m1.setMnemonic('f');
        JMenuItem mi1=new JMenuItem("Open",'o');
        JMenuItem mi2=new JMenuItem("Save",'s');
        JMenuItem mi3=new JMenuItem("Save as",'d');
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        mb.add(m1);
        m3= new JMenu("Edit");
        JRadioButtonMenuItem r1=new JRadioButtonMenuItem("Copy");
        JRadioButtonMenuItem r2=new JRadioButtonMenuItem("Paste");
        m3.add(r1);
        m3.add(r2);
        mb.add(m3);
        m4=new JMenu("view");
        JCheckBoxMenuItem c1=new JCheckBoxMenuItem("zoomin");
        JCheckBoxMenuItem c2=new JCheckBoxMenuItem("zoomout");
        m4.add(c1);
        m4.add(c2);
        mb.add(m4);
        add(mb);
        JTextField t1=new JTextField(40);
        JButton b1=new JButton("Demo button");
        sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,t1,b1);
        sp1.setOneTouchExpandable(true);
        sp1.setDividerSize(20);
        add(sp1);
        JButton dial=new JButton("open dialog box");
        JButton dl=new JButton();
        dial.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               JDialog dia=new JDialog();
               dl.setText("Dialog box opened");
               dia.add(dl);
               dia.setLayout(new GridLayout(1,1));
               dia.setVisible(true);
               dia.setSize(400,200);
               dia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           }
        });
        add(dial);
        JButton fbtn=new JButton("Choose file");
        fbtn.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               JFileChooser fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int x=fileChooser.showOpenDialog(null);
            if(x==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                t1.setText(file.getPath());
            }
           }
        });
        add(fbtn);
        JButton color=new JButton("Color Chooser Button");
        color.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               JColorChooser cc=new JColorChooser();
               Color color=JColorChooser.showDialog(null, "Choose a color", Color.yellow);
               t1.setBackground(color);
           }
        });
        add(color);
        setVisible(true);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        setSize(500,500);
    }
}

public class Menu {
  public static void main(String[] args) {
    Menus meu=new Menus();
    meu.setMenu();
}

}
