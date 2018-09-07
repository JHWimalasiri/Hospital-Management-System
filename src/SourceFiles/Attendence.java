/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceFiles;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jhw
 */
public class Attendence {

    /**
     * @return the staff_id
     */
    public int getStaff_id() {
        return staff_id;
    }

    /**
     * @param staff_id the staff_id to set
     */
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    public Attendence(int staff_id,String date){
        this.staff_id = staff_id;
        this.date = date;
    }
    
    public int addToDb()throws Exception{
        Statement stat = Db.getStatement();
        stat.executeUpdate("INSERT INTO attendence(staff_id,date) values ('"+staff_id+"','"+date+"')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM test");
        result.next();
        return result.getInt(1);
    }
    
    public static ResultSet searchAttendence(int staff_id,String from,String to) throws Exception{
        Statement statement = Db.getStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM attendance WHERE staff_id='"+staff_id+"' AND date BETWEEN '"+from+"' AND '"+to+"'");
        return rs;
    }
    
    
    
    private int staff_id;
    private String date;
}
