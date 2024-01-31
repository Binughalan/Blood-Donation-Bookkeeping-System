/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class tables {
    public static void main(String[]args){
        try{
            String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),username varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(username))";
            DbOperations.setDataOrDelete(userTable,"User Table created successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
    
