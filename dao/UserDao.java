


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.User;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author User
 */
public class UserDao {
    public static void save(User user){
        String query="insert into user(name,username,mobileNumber,address,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getUsername()+"','"+user.getMobileNmber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully!");
 }
    public static User login(String username, String password) {
        User user=null;
        try {
            ResultSet rs=DbOperations.getData("select * from user username='"+username+"'and password='"+password+"'");
            while (rs.next()) {                
                user =new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    public static User getSecurityQuestion (String username) {
        User user=null;
        try {
            ResultSet rs=DbOperations.getData("Select* from user where username='"+username+"'");
            while (rs.next()) {                
                user=new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    public static void update(String username, String newPassword) {
        String query="update user set password='"+newPassword+"'where username='"+username+"'";
        DbOperations.setDataOrDelete(query, "Password Changed Successfully");
    }
}
