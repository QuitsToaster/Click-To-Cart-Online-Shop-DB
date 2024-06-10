package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MyConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/online_shopping";
            String user = "root";
            String password = "00000"; // Update with your MySQL password if set
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

}
