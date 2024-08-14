//using only result set we can fetch data from row 1 to row 2 to row 3 and so on. but using scrollable and updatable result set we can fetch data of any row and also can be updated
import java.sql.*;

public class ScrollableandUpdatetabelDemo {
  public static void main(String[] args) {
    try {
      Connection conn;
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/primecsita";
      String susername = "root";
      String spassword = "";
      conn = DriverManager.getConnection(url, susername, spassword);

      String disQuery = "select * from tbl_reg";
      //creating scrollabel and updatable result set
      //to make result set scrollable
      int scroll = ResultSet.TYPE_SCROLL_SENSITIVE;
      //to create updatable: to update data in database
      int updatable = ResultSet.CONCUR_UPDATABLE;
      //to make readonly
      int read = ResultSet.CONCUR_READ_ONLY;
      Statement st = conn.createStatement(scroll, updatable);
      ResultSet rs = st.executeQuery(disQuery);
      System.out.println("fetching last row data");
      rs.last();
      System.out.println("id is " + rs.getString("id"));
      System.out.println("username is " + rs.getString("username"));
      System.out.println("password is " + rs.getString("password"));
      System.out.println("repassword is " + rs.getString("repassword"));
      System.out.println("gender is " + rs.getString("gender"));
      System.out.println("course is " + rs.getString("course"));
      System.out.println("country is " + rs.getString("country"));

      //to getch data of any row
      System.out.println("fetching 2nd row data");
      rs.absolute(2);
      System.out.println("id is " + rs.getString("id"));
      System.out.println("username is " + rs.getString("username"));

      //updating username to sam for row2
      rs.updateString("username", "sam");
      rs.updateRow();
      System.out.println("id is: "+rs.getString("id"));
      System.out.println("username is: "+rs.getString("username"));
    } catch(SQLException e) {
      System.out.println(e);
    } catch(ClassNotFoundException c) {
      System.out.println(c);
    }
  }
}
