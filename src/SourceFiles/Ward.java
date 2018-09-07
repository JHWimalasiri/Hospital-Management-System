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
public class Ward {
    public Ward(int ward_no, String ward_name, int no_patients){
        this.ward_no = ward_no;
        this.ward_name = ward_name;
        this.no_patients = no_patients;
    }
    /**
     * @return the ward_no
     */
    public int getWard_no() {
        return ward_no;
    }

    /**
     * @param ward_no the ward_no to set
     */
    public void setWard_no(int ward_no) {
        this.ward_no = ward_no;
    }

    /**
     * @return the ward_name
     */
    public String getWard_name() {
        return ward_name;
    }

    /**
     * @param ward_name the ward_name to set
     */
    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }

    /**
     * @return the no_patients
     */
    public int getNo_patients() {
        return no_patients;
    }
    
    public int addToDb()throws Exception{
        Statement stat = Db.getStatement();
        stat.executeUpdate("INSERT INTO ward(ward_name) values ('"+ward_name+"')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM ward");
        result.next();
        return result.getInt(1);
    }
    
    public static Ward searchWard(int id)throws Exception{
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM ward WHERE ward_no='"+id+"'");
        if(result.next()){
            return new Ward(id,result.getString(2),result.getInt(3));
        }
        return null;
    }
    
    public boolean updateWard()throws Exception{
        if(searchWard(ward_no) == null){
            return false;
        }
            Statement stat = Db.getStatement();
            stat.executeUpdate("UPDATE ward SET ward_name = '"+ward_name+"' WHERE ward_no='"+ward_no+"'");
        return true;
        
    }
    
    public static boolean deleteWard(int id)throws Exception{
        Ward w1 = Ward.searchWard(id);
        if(w1==null){
            return false;
        
        }
        Statement stat = Db.getStatement();
        stat.executeUpdate("DELETE FROM ward WHERE ward_no = '"+id+"'");
            
        return true;
    }
    
    
    /**
     * @param no_patients the no_patients to set
     */
    public void setNo_patients(int no_patients) {
        this.no_patients = no_patients;
    }
    private int ward_no;
    private String ward_name;
    private int no_patients;
}
