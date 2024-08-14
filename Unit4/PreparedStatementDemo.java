//prepared statement is used to handle dynamic data
import java.sql.*;

class PreparedEg{
  Connection conn;
  public void insertData(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/primecsita";
      String susername = "root";
      String spassword = "";
      conn = DriverManager.getConnection(url, susername, spassword);

      // //inserting data int database
      // Scanner sc = new Scanner(System.in);
      // System.out.println("Enter id:");
      // String id = sc.next();
      // System.out.println("Enter username:");
      // String uname = sc.next();
      // System.out.println("Enter password:");
      // String pass = sc.next();
      // System.out.println("Enter repassword:");
      // String repass = sc.next();
      // System.out.println("Enter your gender:");
      // String gender = sc.next();
      // System.out.println("Enter your course:");
      // String course = sc.next();
      // System.out.println("Enter your country:");
      // String country = sc.next();

      // //query
      // String insQuery="insert into tbl_reg values(?,?,?,?,?,?,?)";
      // PreparedStatement ps = conn.prepareStatement(insQuery);
      // ps.setString(1, id);
      // ps.setString(2, uname);
      // ps.setString(3, pass);
      // ps.setString(4, repass);
      // ps.setString(5, gender);
      // ps.setString(6, course);
      // ps.setString(7, country);

      // int res = ps.executeUpdate();
      // if(res>0){
      //   System.out.println(res+" data inserted into table");
      // }

      // conn.close();

      //fetching data
      System.out.println("--------fetching data into db--------------");
      String disQuery="select * from tbl_reg";
      // //display record of person whose id is given by user
      // Scanner sc1 = new Scanner(System.in);
      // System.out.println("Enter id to display record:");
      // int id1 = sc1.nextInt();
      // String disQuery1="select * from tbl_reg where id=?";
      // PreparedStatement ps2 = conn.prepareStatement(disQuery1);
      // ps2.setString(1, id1);
      PreparedStatement ps1 = conn.prepareStatement(disQuery);
      ResultSet rs = ps1.executeQuery();
      while(rs.next()){
        String did = rs.getString("id");
        String duname = rs.getString("username");
        String dpass = rs.getString("password");
        String drepass = rs.getString("repassword");
        String dgender = rs.getString("gender");
        String dcourse = rs.getString("course");
        String dcountry = rs.getString("country");
        System.out.println(did+" "+duname+" "+dpass+" "+drepass+" "+dgender+" "+dcourse+" "+dcountry);
      }
      conn.close();
    } catch (ClassNotFoundException c) {
      System.out.println(c);
    } catch (SQLException s) {
      System.out.println(s);
    }
  }
}

public class PreparedStatementDemo {
  public static void main(String[] args) {
    PreparedEg pe = new PreparedEg();
    pe.insertData();
    // pe.fetchData();
  }
}
