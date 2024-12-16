package Lab4;

import java.sql.*;
public class Crud {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java";
            String suname="root";
            String spass="";
            Connection conn=DriverManager.getConnection(url,suname,spass);
            if(conn!=null){
                System.out.println("Database Connection successfull");
            }else{
                System.out.println("Database Not connected");
            }
            // String tblQuery="create table tbl_lab ("
            //         + "id int primary key,username varchar(50),"
            //         + "password varchar(50),"
            //         + "repassword varchar(50),"
            //         + "gender varchar(50),"
            //         + "course varchar(50),"
            //         + "country varchar(50) )";
            // Statement st=conn.createStatement();
            // st.execute(tblQuery);
            // System.out.println("Table created");
            System.out.println("--------Inserting data into db--------------");
            String insQuery="insert into tbl_lab values(3,'Pewds','qwer','qwer','male','bca','japan')";
            Statement st1=conn.createStatement();
            int res=st1.executeUpdate(insQuery);
            if(res>0){
                
            System.out.println(res+" data inserted into table");
            }                
            System.out.println("-----------fetching data from database---------------");
            String fetchQuery="select * from tbl_lab";
            Statement st2=conn.createStatement();
            ResultSet rs=st2.executeQuery(fetchQuery);
            while(rs.next()){
                int id=rs.getInt("id");
                String uname=rs.getString("username");
                String pass=rs.getString("password");
                String repass=rs.getString("repassword");
                String gender=rs.getString("gender");
                String course=rs.getString("course");
                String country=rs.getString("country");
                System.out.println("id is: "+id+"\nUsername is: "+uname
                        +"\nPassword is: "+pass+
                        "\nRepassword is: "+repass+
                        "\nGender is: "+gender+
                        "\nCourse is: "+course+
                        "\nCountry is: "+country);
            }
            // System.out.println("-----------Updating data from database---------------");
            // String upQuery="update tbl_lab set username='Pewdiepie' where id='1'";
            // Statement st4=conn.createStatement();
            // int res4=st4.executeUpdate(upQuery);
            // if(res4>0){
            //     System.out.println("Data Updated");
            // }           
            // System.out.println("-----------------Deleting data from data--------------------");
            // String delQuery="delete from tbl_lab where id='1'";
            // Statement st3=conn.createStatement();
            // int res1=st3.executeUpdate(delQuery);
            // if(res1>0){
            //     System.out.println("Data deleted Successfully");
            // }
            conn.close();
            
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException c){
            System.out.println(c);
        }
    }
}
