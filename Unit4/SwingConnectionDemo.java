import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Form extends JFrame{  //inheritng properties of JFrame
  //create instance variables of controls
  JLabel l0, l1, l2, l3, l4, l5, l6, l7;
  JTextField t0, t1;
  JPasswordField p1, p2;
  JRadioButton r1, r2;
  JCheckBox c1, c2, c3;
  JComboBox cb1;
  JButton b1;

  //create object of each control
  public void setForm(){
    l0 = new JLabel("ID");
    l1 = new JLabel("Username");
    l2 = new JLabel("Password");
    l3 = new JLabel("RePassword");
    l4 = new JLabel("Gender");
    l5 = new JLabel("Course");
    l6 = new JLabel("Country");
    l7 = new JLabel("Result");
    t0 = new JTextField(20);
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
    add(l0);add(t0);
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

    //after button is pressed, action event is generated
    b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        String id = t0.getText();
        String uname = t1.getText();
        String pass = new String(p1.getPassword());
        String repass = new String(p2.getPassword());
        //radio
        String gender = "";
        if(r1.isSelected()){
          gender = r1.getText();
        } else {
          gender = r2.getText();
        }
        //checkbox
        String course = "";
        if(c1.isSelected()){
          course += c1.getText() + " ";
        }
        if(c2.isSelected()){
          course += c2.getText() + " ";
        }
        if(c3.isSelected()){
          course += c3.getText() + " ";
        }
        //combobox
        String country = "";
        if(cb1.getSelectedItem().toString()!=null){
          country = (String)cb1.getSelectedItem();
        }
        //display result
        l7.setText(
          "username" + uname + "\n " + 
          "password" + pass + "\n " + 
          "repassword" + repass + "\n " + 
          "gender" + gender + "\n " + 
          "course" + course + "\n " + 
          "country" + country
        );

        //connect to database
        try {
          Connection conn;
          Class.forName("com.mysql.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/primecsita";
          String susername = "root";
          String spassword = "";
          conn = DriverManager.getConnection(url, susername, spassword);
          String insQuery="insert into tbl_reg values(?,?,?,?,?,?,?)";
          PreparedStatement ps = conn.prepareStatement(insQuery);
          ps.setString(1, id);
          ps.setString(2, uname);
          ps.setString(3, pass);
          ps.setString(4, repass);
          ps.setString(5, gender);
          ps.setString(6, course);
          ps.setString(7, country);

          int res = ps.executeUpdate();
          if(res>0){
            System.out.println(res+" data inserted into table");
          }
          
        } catch (SQLException s) {
          System.out.println(s);
        } catch (ClassNotFoundException c) {
          System.out.println(c);
        }
        
      }
    });
  }
}

public class SwingConnectionDemo {
  public static void main(String[] args) {
    Form f = new Form();
    f.setForm();
  } 
}
