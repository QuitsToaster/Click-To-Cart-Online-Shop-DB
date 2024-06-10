package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ForgotPasswordDao {
    Connection conn = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public boolean isEmailExist(String email){
        try {
            ps = conn.prepareStatement("select * from user where uemail = ?");
             ps.setString(1, email);
             rs = ps.executeQuery();
             if(rs.next()){
                 return true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    //set new password
    
    public void setPassword(String email, String password){
        String sql = "update user set upassword = ? where uemail = ?";
        try { 
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            if(ps.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "Password updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
