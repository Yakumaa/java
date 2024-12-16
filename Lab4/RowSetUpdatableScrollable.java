package Lab4;
import java.sql.*;
import javax.sql.rowset.*;
class rowSet{
    public void rowDemo(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        JdbcRowSet jrs=RowSetProvider.newFactory().createJdbcRowSet();
        String url="jdbc:mysql://localhost:3306/java";
        jrs.setUrl(url);
        jrs.setUsername("root");
        jrs.setPassword("");
        jrs.setCommand("Select * from tbl_lab");
        jrs.execute();
            System.out.println("=====fetch 2nd row data==");
            jrs.absolute(2);
             System.out.println("id is: "+jrs.getString("id"));
            System.out.println("username is: "+jrs.getString("username"));
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException s){
            System.out.println(s);
        }
    }
}
public class RowSetUpdatableScrollable {
    public static void main(String[] args) {
        rowSet rw=new rowSet();
        rw.rowDemo();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java";
                    String suname="root";
                    String spass="";
                    
            Connection conn=DriverManager.getConnection(url,suname,spass);
            String disQuery ="select * from tbl_lab";
            int scroll=ResultSet.TYPE_SCROLL_SENSITIVE;
            int updatable=ResultSet.CONCUR_UPDATABLE;
            Statement st=conn.createStatement(scroll,updatable);
            ResultSet rs=st.executeQuery(disQuery);
            System.out.println("---fetching last row data---------");
            rs.last();
            System.out.println("id is: "+rs.getString("id"));
            System.out.println("username is: "+rs.getString("username"));
            System.out.println("password is: "+rs.getString("password"));
            System.out.println("repassword is: "+rs.getString("repassword"));
            System.out.println("gender is: "+rs.getString("gender"));
            System.out.println("course is: "+rs.getString("course"));
            System.out.println("country is: "+rs.getString("country"));
            
            System.out.println("-------fetching 3rd row data");
            rs.absolute(3);
            System.out.println("id is: "+rs.getString("id"));
            System.out.println("username is: "+rs.getString("username"));
            
            System.out.println("-------updating 2nd row data");
            rs.absolute(2);
            rs.updateString("username", "hello");
            rs.updateRow();
            System.out.println("id is: "+rs.getString("id"));
            System.out.println("username is: "+rs.getString("username"));
        }catch(SQLException s){
            System.out.println(s);
        }catch(ClassNotFoundException c){
            System.out.println(c);
        }
    }
}
