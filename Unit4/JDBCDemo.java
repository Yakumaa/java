//to connect with exteral data source like xml file sql server etv JDBC driver is required 
//step1: initialize JDBC drive usein Class.forName
//step2: connect with database using connection obj
//for this DriverManager.getConnection() it takes three parameter url, server username, 
//step3: write proper query and exeute it with statement object
//step4: 

import java.sql.*;
public class JDBCDemo {
  public static void main(String[] args){
    try {
        //step1:
        Class.forName("com.sql.cj.jdbc.Driver");
        //step2
        Connection conn;
        String url = "jdbc:mysql:/localhost:3306/primecsita";
        String susername = "root";
        String password = "";
        conn = DriverManager.getConnection(url, susername, password);
        if(conn!=null){
          System.out.println("Database COnnection successfull");
        }else{
            System.out.println("Database Not connected");
        }
        //creating table
        String tblQuery="create table tbl_reg ("
                    + "id int primary key,"
                    + "username varchar(50),"
                    + "password varchar(50),"
                    + "repassword varchar(50),"
                    + "gender varchar(50),"
                    + "course varchar(50),"
                    + "country varchar(50) )";

        //execute query: Statement object is used
        Statement st=conn.createStatement();
        st.execute(tblQuery);
        System.out.println("Table created");
        conn.close();

        // //inserting data int database
        // System.out.println("--------Inserting data into db--------------");
        // String insQuery="insert into tbl_reg values(1,'poem','abcd','abcd','male','csit','nepal')";
        // Statement st=conn.createStatement();
        // int res=st.executeUpdate(insQuery);
        // if(res>0){
            
        // System.out.println(res+" data inserted into table");
        // }
        // conn.close();

        // //fetching data int database
        // System.out.println("--------fetching data into db--------------");
        // String disQuery="select * from tbl_reg";)";
        // Statement st1=conn.createStatement();
        // //to fetch data executeQuery() is used whihc return object of ResultSet
        // ResultSet rs=st1.executeQuery(disQuery);
        // while(rs.next()){ 
          // int id = rs.getInt("id");
          // String uname = rs.getString("username");
          // String pass = rs.getString("password");
          // String repass = rs.getString("repassword");
          // String gender = rs.getString("gender");
          // String course = rs.getString("course");
          // String country = rs.getString("country");
          // System.out.println(id+" "+uname+" "+pass+" "+re+ " "+gender+" "+course+" "+country);
        // }

        // int res=st.executeUpdate(insQuery);
        // if(res>0){
            
        // System.out.println(res+" data inserted into table");
        // }
        // conn.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e);
    } catch (SQLException s) {
      System.out.println(s);
    }
  }
}
