import javax.sql.rowset.*;

public class RowSetExample {
  public static void main(String[] args){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl("jdbc:mysql://localhost:3306/java");
        cachedRowSet.setUsername("root");
        cachedRowSet.setPassword("");

        cachedRowSet.setCommand("select * from tbl_lab");
        cachedRowSet.execute();

        System.out.println("=====fetch 2nd row data==");
        cachedRowSet.absolute(2);
        System.out.println("id is: "+cachedRowSet.getString("id"));
        System.out.println("username is: "+cachedRowSet.getString("username"));

        //update
        cachedRowSet.absolute(2);
        cachedRowSet.updateString("username", "hello");
        cachedRowSet.updateRow();

        // cachedRowSet.acceptChanges();
    } catch (Exception e) {
        System.out.println(e);
    }
  }
}
