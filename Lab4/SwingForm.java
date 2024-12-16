package Lab4;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class Forms extends JFrame implements ActionListener{
    JLabel l0, l1, l2, l3, l4, l5, l6, l7;
    JTextField t0, t1;
    JPasswordField p1, p2;
    JRadioButton r1, r2;
    ButtonGroup bg;
    JCheckBox c1, c2, c3;
    JComboBox<String> cb1;
    JButton b1, b2;
    public Forms() {
        l0 = new JLabel("Id");
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Repassword");
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
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        c1 = new JCheckBox("C");
        c2 = new JCheckBox("C++");
        c3 = new JCheckBox("Java");
        String[] items = {"Nepal", "USA", "Japan", "Other"};
        cb1 = new JComboBox<>(items);
        b1 = new JButton("Submit");
        b2 = new JButton("Reset");
        setLayout(new FlowLayout());
        add(l0); add(t0);
        add(l1); add(t1);
        add(l2); add(p1);
        add(l3); add(p2);
        add(l4); add(r1); add(r2);
        add(l5); add(c1); add(c2); add(c3);
        add(l6); add(cb1);
        add(b1); add(b2); add(l7);
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String id = t0.getText();
            String uname = t1.getText();
            String pass = String.valueOf(p1.getPassword());
            String repass = String.valueOf(p2.getPassword());
            String gender = r1.isSelected() ? "Male" : "Female";
            String course = "";
            if (c1.isSelected()) course += "C ";
            if (c2.isSelected()) course += "C++ ";
            if (c3.isSelected()) course += "Java";
            String country = (String) cb1.getSelectedItem();
            if (id.isEmpty() || uname.isEmpty() || pass.isEmpty() || repass.isEmpty() || course.isEmpty() || country.isEmpty()) {
                l7.setText("All fields are required");
                return;
            }
            if (!pass.equals(repass)) {
                l7.setText("Passwords do not match");
                return;
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/java";
                String suname = "root";
                String spass = "";
                Connection conn = DriverManager.getConnection(url, suname, spass);
                String insQuery = "INSERT INTO tbl_lab (id, username, password, repassword, gender, course, country) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(insQuery);
                ps.setString(1, id);
                ps.setString(2, uname);
                ps.setString(3, pass);
                ps.setString(4, repass);
                ps.setString(5, gender);
                ps.setString(6, course);
                ps.setString(7, country);
                int res = ps.executeUpdate();
                if (res > 0) {
                    l7.setText("Data inserted successfully");
                }
                conn.close();
            } catch (SQLException | ClassNotFoundException ex) {
                l7.setText("Database error: " + ex.getMessage());
            }
        } else if (e.getSource() == b2) {
            t0.setText("");
            t1.setText("");
            p1.setText("");
            p2.setText("");
            bg.clearSelection();
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            cb1.setSelectedIndex(0);
            l7.setText("");
        }
    }
}
class LoginForm extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1;
    public LoginForm() {
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Result");
        t1 = new JTextField(20);
        p1 = new JPasswordField(20);
        b1 = new JButton("Login");
        setLayout(new FlowLayout());
        add(l1); add(t1);
        add(l2); add(p1);
        add(b1); add(l3);
        setVisible(true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String uname = t1.getText();
        String pass = String.valueOf(p1.getPassword());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java";
            String suname = "root";
            String spass = "";
            Connection conn = DriverManager.getConnection(url, suname, spass);
            String query = "SELECT * FROM tbl_lab WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                l3.setText("Login successful!");
                rs.beforeFirst();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    if (id == 3) {
                        rs.updateString("username", "sanu");
                        rs.updateString("course", "BCA");
                        rs.updateRow(); 
                    } else if (id == 5) {
                        rs.updateString("country", "USA");
                        rs.updateRow(); 
                    }
                }
                rs.beforeFirst(); 
                while (rs.next()) {
                    String name = rs.getString("username");
                    if (name.equalsIgnoreCase("sam")) {
                        rs.deleteRow();                     }
                }
                displayTableRecords(conn);
            } else {
                l3.setText("Invalid username or password");
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            l3.setText("Database error: " + ex.getMessage());
        }
    }
    private void displayTableRecords(Connection conn) {
        JFrame frame = new JFrame("Table Records");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] columnNames = {"ID", "Username", "Password", "Gender", "Course", "Country"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        try {
            String query = "SELECT * FROM tbl_lab";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String course = rs.getString("course");
                String country = rs.getString("country");
                model.addRow(new Object[]{id, username, password, gender, course, country});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
public class SwingForm {
    public static void main(String[] args) {
        Forms form = new Forms();
         LoginForm login = new LoginForm();
    }
}
