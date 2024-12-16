package Lab4;
import java.sql.*;
import java.util.*;
class PreparedEg{
    Connection conn;
    public void createTable(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java";
            String susername="root";
            String spassword="";
            conn=DriverManager.getConnection(url,susername,spassword);
            String tblQuery="create table lab4_2 ("
                    + "id int primary key,username varchar(50),"
                    + "password varchar(50),"
                    + "repassword varchar(50),"
                    + "gender varchar(50),"
                    + "course varchar(50),"
                    + "country varchar(50) )";
            Statement st=conn.createStatement();
            st.execute(tblQuery);
            System.out.println("Table created");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void insertData(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java";
            String susername="root";
            String spassword="";
            conn=DriverManager.getConnection(url,susername,spassword);
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your id:");
            String id=sc.next();
            System.out.println("Enter your username:");
            String uname=sc.next();
            System.out.println("Enter your password:");
            String pass=sc.next();
            System.out.println("Enter your repassword:");
            String repass=sc.next();
            System.out.println("Enter your gender:");
            String gender=sc.next();
            System.out.println("Enter your course:");
            String course=sc.next();
            System.out.println("Enter your country:");
            String country=sc.next();
            String insQuery=
                    "insert into lab4_2 values(?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(insQuery);
            ps.setString(1, id);
            ps.setString(2,uname);
            ps.setString(3,pass);
            ps.setString(4,repass);
            ps.setString(5,gender);
            ps.setString(6,course);
            ps.setString(7,country);
            
            int res=ps.executeUpdate();
            if(res>0){
                System.out.println(res+" data inserted");
            }
            conn.close();
            
        }catch(ClassNotFoundException c){
            System.out.println(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void fetchData(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java";
            String susername="root";
            String spassword="";
            conn=DriverManager.getConnection(url,susername,spassword);
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter id of person: ");
            String id=sc1.next();
            String disQuery1="select * from lab4_2 where id=?";
            PreparedStatement ps1=conn.prepareStatement(disQuery1);
            ps1.setString(1,id);
            ResultSet rs=ps1.executeQuery();
            while(rs.next()){
                String did=rs.getString("id");
                String duname=rs.getString("username");
                String dpass=rs.getString("password");
                String drepass=rs.getString("repassword");
                String dgender=rs.getString("gender");
                String dcourse=rs.getString("course");
                String dcountry=rs.getString("country");
                System.out.println("id is: "+did+"\nUsername is: "+duname
                        +"\nPassword is: "+dpass+
                        "\nRepassword is: "+drepass+
                        "\nGender is: "+dgender+
                        "\nCOurse is: "+dcourse+
                        "\ncountry is: "+dcountry);
            }
            conn.close();
        }catch(ClassNotFoundException c){
            System.out.println(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void updateData(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java";
            String susername="root";
            String spassword="";
            conn=DriverManager.getConnection(url,susername,spassword);
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter course of person: ");
            String ucourse=sc1.next();
            System.out.println("Enter country of person: ");
            String ucountry=sc1.next();
            String upQuery="update lab4_2 set course=?,country=? where id='1'";
            PreparedStatement ps1=conn.prepareStatement(upQuery);
            ps1.setString(1,ucourse);
            ps1.setString(2,ucountry);
            int res2=ps1.executeUpdate();
            if(res2>0){
                System.out.println(res2+" data updated");
            }
            conn.close();
        }catch(ClassNotFoundException c){
            System.out.println(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void delData(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java";
            String susername="root";
            String spassword="";
            conn=DriverManager.getConnection(url,susername,spassword);
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter id of person whose record is to be deleted: ");
            String did=sc1.next();
            
            String delQuery="delete from lab4_2 where id=?";
            PreparedStatement ps1=conn.prepareStatement(delQuery);
            ps1.setString(1,did);
            int res2=ps1.executeUpdate();
            if(res2>0){
                System.out.println(res2+" data deleted");
            }
            conn.close();
        }catch(ClassNotFoundException c){
            System.out.println(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}

public class CrudPreparedStatements {
    public static void main(String[] args) {
                PreparedEg p=new PreparedEg();
                p.createTable();
                p.insertData();
                p.fetchData();
                p.updateData();
                p.fetchData();
                p.delData();
    }
}
