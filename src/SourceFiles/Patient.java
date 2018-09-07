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
public class Patient {

    /**
     * @return the patient_id
     */
    public int getPatient_id() {
        return patient_id;
    }

    /**
     * @param patient_id the patient_id to set
     */
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the guardian
     */
    public String getGuardian() {
        return guardian;
    }

    /**
     * @param guardian the guardian to set
     */
    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    /**
     * @return the relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * @param relationship the relationship to set
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * @return the admission_date
     */
    public String getAdmission_date() {
        return admission_date;
    }

    /**
     * @param admission_date the admission_date to set
     */
    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }

    /**
     * @return the discharge_date
     */
    public String getDischarge_date() {
        return discharge_date;
    }

    /**
     * @param discharge_date the discharge_date to set
     */
    public void setDischarge_date(String discharge_date) {
        this.discharge_date = discharge_date;
    }

    /**
     * @return the due_payment
     */
    public double getDue_payment() {
        return due_payment;
    }

    /**
     * @param due_payment the due_payment to set
     */
    public void setDue_payment(double due_payment) {
        this.due_payment = due_payment;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
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
     * @return the external_phy
     */
    public String getExternal_phy() {
        return external_phy;
    }

    /**
     * @param external_phy the external_phy to set
     */
    public void setExternal_phy(String external_phy) {
        this.external_phy = external_phy;
    }

    /**
     * @return the consultant
     */
    public int getConsultant() {
        return consultant;
    }

    /**
     * @param consultant the consultant to set
     */
    public void setConsultant(int consultant) {
        this.consultant = consultant;
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
     * @return the confirmation
     */
    public int getConfirmation() {
        return confirmation;
    }

    /**
     * @param confirmation the confirmation to set
     */
    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }
    
    public Patient(int patient_id,int nic,String first_name,String last_name,String dateOfBirth,String address,String guardian,String relationship,String admission_date,String discharge_date,double due_payment,int status,String gender,int contact_home,int contact_mobile,String external_phy,int consultant,int ward_no,int confirmation){
        this.patient_id = patient_id;
        this.nic = nic;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.guardian = guardian;
        this.relationship = relationship;
        this.admission_date = admission_date;
        this.discharge_date = discharge_date;
        this.due_payment = due_payment;
        this.status = status;
        this.gender = gender;
        this.contact_home = contact_home;
        this.contact_mobile = contact_mobile;
        this.external_phy = external_phy;
        this.consultant = consultant;
        this.ward_no = ward_no;
        this.confirmation = confirmation;
    }
    
    public int addToDb()throws Exception{
        Statement stat = Db.getStatement();
        stat.executeUpdate("INSERT INTO patient(patient_id,nic,first_name,last_name,dateOfBirth,address,guardian,relationship,admission_date,status,gender,contact_home,contact_mobile,external_phy,consultant,ward_no,confirmation) values ('"+patient_id+"','"+nic+"','"+first_name+"','"+last_name+"','"+dateOfBirth+"','"+address+"','"+guardian+"','"+relationship+"','"+admission_date+"','"+0+"','"+gender+"','"+contact_home+"','"+contact_mobile+"','"+external_phy+"','"+consultant+"','"+ward_no+"','"+confirmation+"')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM patient");
        result.next();
        int id = result.getInt(1);
        
        
        return id;
    }
    
    public static Patient searchPatient(int id)throws Exception{
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM patient WHERE patient_id='"+id+"'");
        if(result.next()){
            Patient pat = new Patient(id,result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10),result.getDouble(11),result.getInt(12),result.getString(13),result.getInt(14),result.getInt(15),result.getString(16),result.getInt(17),result.getInt(18),result.getInt(19));
            
            return pat;
        }
        return null;
    }
    
    public boolean updatePatient()throws Exception{
        Patient pat = searchPatient(patient_id);
        if(pat== null){
            return false;
        }
        else{
            Statement stat = Db.getStatement();
            stat.executeUpdate("UPDATE patient SET nic = '"+nic+"',first_name = '"+first_name+"',last_name = '"+last_name+"',dateOfBirth = '"+dateOfBirth+"',address='"+address+"',guardian = '"+guardian+"',relationship = '"+relationship+"',admission_date = '"+admission_date+"',discharge_date = '"+discharge_date+"',due_payment = '"+due_payment+"',status = '"+status+"',gender = '"+gender+"',contact_home='"+contact_home+"',contact_mobile='"+contact_mobile+"',external_phy = '"+external_phy+"',consultant = '"+consultant+"',ward_no = '"+ward_no+"',confirmation = '"+confirmation+"' WHERE patient_id='"+patient_id+"'");
            if(pat.getStatus()==0){
                if(status==1){
                    Ward w = Ward.searchWard(ward_no);
                    w.setNo_patients(w.getNo_patients()+1);
                    stat.executeUpdate("UPDATE ward SET ward_name = '"+w.getWard_name()+"',no_patients = '"+w.getNo_patients()+"' WHERE ward_no = '"+w.getWard_no()+"'");
                }
            }
            else{
                if(pat.status==1){
                    if(pat.ward_no!=ward_no){
                       Ward w = Ward.searchWard(ward_no);
                        w.setNo_patients(w.getNo_patients()+1);
                        stat.executeUpdate("UPDATE ward SET ward_name = '"+w.getWard_name()+"',no_patients = '"+w.getNo_patients()+"' WHERE ward_no = '"+w.getWard_no()+"'"); 
                    
                        Ward w1 = Ward.searchWard(pat.ward_no);
                        w.setNo_patients(w.getNo_patients()-1);
                        stat.executeUpdate("UPDATE ward SET ward_name = '"+w.getWard_name()+"',no_patients = '"+w.getNo_patients()+"' WHERE ward_no = '"+w.getWard_no()+"'");
                    }
                    
                    else{
                        Ward w = Ward.searchWard(ward_no);
                        w.setNo_patients(w.getNo_patients()-1);
                        stat.executeUpdate("UPDATE ward SET ward_name = '"+w.getWard_name()+"',no_patients = '"+w.getNo_patients()+"' WHERE ward_no = '"+w.getWard_no()+"'");
                    }
                }
            }
            
        }
            
        return true;
        
    }
    
    public static boolean deletePatient(int id)throws Exception{
        Patient stf = Patient.searchPatient(id);
        if(stf==null){
            return false;
        
        }
        Statement stat = Db.getStatement();
        stat.executeUpdate("DELETE FROM patient WHERE patient_id = '"+id+"'");
            
        return true;
    }
    
    private int patient_id;
    private int nic;
    private String first_name;
    private String last_name;
    private String dateOfBirth;
    private String address;
    private String guardian;
    private String relationship;
    private String admission_date;
    private String discharge_date;
    private double due_payment;
    private int status;
    private String gender;
    private int contact_home;
    private int contact_mobile;
    private String external_phy;
    private int consultant;
    private int ward_no;
    private int confirmation;

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
}
