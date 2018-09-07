/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceFiles;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jhw
 */
public class User {

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
     public User(String username,String password,String type){
         this.username = username;
         this.password = password;
         this.type = type;
     }
     
     public void addToDb()throws Exception{
         Statement stat = Db.getStatement();
        stat.executeUpdate("INSERT INTO login(username,password,type) values ('"+username+"','"+password+"','"+type+"')");
     }
     
     public static User searchUser(String username)throws Exception{
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM login WHERE username='"+username+"'");
        if(result.next()){
            return new User(result.getString(1),result.getString(2),result.getString(3));
        }
        return null;
    }
     
     public boolean updateUser()throws Exception{
         if(searchUser(username) == null){
            return false;
        }
            Statement stat = Db.getStatement();//type never changes
            
            stat.executeUpdate("UPDATE User SET username = '"+username+"',password = '"+password+"'");
        return true;
     }
     
     
    
   private String username;
   private String password;
   private String type;
}
