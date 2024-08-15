/*
fetching data in JTable
 */

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class DisplayEg extends JFrame{
    JTable jt;
    public void setDisplay(){
        jt=new JTable();
        //adding column to JTable
        //set size of table
        jt.setPreferredScrollableViewportSize(new Dimension(300,300));
        JScrollPane js=new JScrollPane(jt);
        add(js);
        setVisible(true);
        setSize(400,400);
        //to show components in particular format
        setLayout(new FlowLayout());
        //to end the program if window is close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        DefaultTableModel dt= (DefaultTableModel)jt.getModel();
        dt.addColumn("id");
        dt.addColumn("username");
        dt.addColumn("password");
        dt.addColumn("repassword");
        dt.addColumn("gender");
        dt.addColumn("course");
        dt.addColumn("country");
                
        //connecti to database and display result
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step 2: connect with database
            String url="jdbc:mysql://localhost:3306/primecsita";
                    // protocol      server:port    database
                    String suname="root";
                    String spass="";
                    
            Connection conn=DriverManager.getConnection(url,suname,spass);
            String disQuery="select * from tbl_reg";
            
            PreparedStatement ps=conn.prepareStatement(disQuery);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                 String did=rs.getString("id");
                String duname=rs.getString("username");
                String dpass=rs.getString("password");
                String drepass=rs.getString("repassword");
                String dgender=rs.getString("gender");
                String dcourse=rs.getString("course");
                String dcountry=rs.getString("country");
                dt.addRow(new Object[]{did,duname,dpass,drepass,dgender,dcourse,dcountry});
            }
        }catch(SQLException s){
            System.out.println(s);
        }catch(ClassNotFoundException c){
            System.out.println(c);
        }
    }
}
public class SwingJTableDemo {
    public static void main(String[] args) {
        DisplayEg deg=new DisplayEg();
        deg.setDisplay();
    }
}