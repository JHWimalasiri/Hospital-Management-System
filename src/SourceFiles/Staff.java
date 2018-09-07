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
public class Staff {

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the nic
     */
    public int getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(int nic) {
        this.nic = nic;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    
    private String specialization;
    public Staff(int staff_id,int nic, String fname, String lname,String dateOfBirth,String gender, String type, int contact_home, int contact_mobile, String address,String specialization){
        this.staff_id = staff_id;
        this.nic = nic;
        this.fname = fname;
        this.lname = lname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.type = type;
        this.contact_home = contact_home;
        this.contact_mobile = contact_mobile;
        this.address = address;
        this.specialization = specialization;
    }
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
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
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

    /**
     * @return the contact_home
     */
    public int getContact_home() {
        return contact_home;
    }

    /**
     * @param contact_home the contact_home to set
     */
    public void setContact_home(int contact_home) {
        this.contact_home = contact_home;
    }

    /**
     * @return the contact_mobile
     */
    public int getContact_mobile() {
        return contact_mobile;
    }

    /**
     * @param contact_mobile the contact_mobile to set
     */
    public void setContact_mobile(int contact_mobile) {
        this.contact_mobile = contact_mobile;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    
    public int addToDb()throws Exception{
        Statement stat = Db.getStatement();
        stat.executeUpdate("INSERT INTO staff(staff_id,nic,fname,lname,dateOfBirth,gender,type,contact_home,contact_mobile,address) values ('"+staff_id+"','"+nic+"','"+fname+"','"+lname+"','"+dateOfBirth+"','"+gender+"','"+type+"','"+contact_home+"','"+contact_mobile+"','"+address+"')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM staff");
        result.next();
        int id = result.getInt(1);
        
        if(type.equals("Doctor")){
            stat.executeUpdate("INSERT INTO doctor(doc_id,specialization) values ('"+id+"','"+specialization+"')");
        }
        return id;
    }
    
    public static Staff searchStaff(int id)throws Exception{
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM staff WHERE staff_id='"+id+"'");
        if(result.next()){
            Staff stf = new Staff(id,result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getInt(8),result.getInt(9),result.getString(10),"");
            if(result.getString(7).equals("Doctor")){
                ResultSet res = stat.executeQuery("SELECT * FROM doctor WHERE doc_id='"+id+"'");
                res.next();
                stf.setSpecialization(res.getString(2));
            }
            return stf;
        }
        return null;
    }
    
    public boolean updateStaff()throws Exception{
        if(searchStaff(staff_id) == null){
            return false;
        }
            Statement stat = Db.getStatement();//type never changes
            if(type.equals("Doctor")){
                stat.executeUpdate("UPDATE staff SET nic = '"+nic+"',fname = '"+fname+"',lname = '"+lname+"',dateOfBirth = '"+dateOfBirth+"',gender = '"+gender+"',type ='"+type+"',contact_home='"+contact_home+"',contact_mobile='"+contact_mobile+"',address='"+address+"'WHERE staff_id='"+staff_id+"'");
                stat.executeUpdate("UPDATE doctor SET specialization = '"+specialization+"'WHERE doc_id='"+staff_id+"'");
                return true;
            }
            stat.executeUpdate("UPDATE staff SET nic = '"+nic+"',fname = '"+fname+"',lname = '"+lname+"',dateOfBirth = '"+dateOfBirth+"',gender = '"+gender+"',type ='"+type+"',contact_home='"+contact_home+"',contact_mobile='"+contact_mobile+"',address='"+address+"' WHERE staff_id='"+staff_id+"'");
        return true;
        
    }
    
    public static boolean deleteStaff(int id)throws Exception{
        Staff stf = Staff.searchStaff(id);
        if(stf==null){
            return false;
        
        }
        Statement stat = Db.getStatement();
        stat.executeUpdate("DELETE FROM staff WHERE staff_id = '"+id+"'");
            
        return true;
    }
    
    
    public void setAddress(String address) {
        this.address = address;
    }
    private int staff_id;
    private String dateOfBirth;
    private int nic;
    private String gender;
    private String fname;
    private String lname;
    private String type;
    private int contact_home;
    private int contact_mobile;
    private String address;
}
