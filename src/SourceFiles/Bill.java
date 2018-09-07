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
public class Bill {

    /**
     * @return the billId
     */
    public int getBillId() {
        return billId;
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(int billId) {
        this.billId = billId;
    }

    /**
     * @return the patientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
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

    /**
     * @return the payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }
    
    public Bill(int billId, int patientId, String time,String date,double payment){
        this.billId = billId;
        this.patientId = patientId;
        this.time = time;
        this.date = date;
        this.payment = payment;
        
    }
    public int addToDb()throws Exception{
        Statement stat = Db.getStatement();
        Patient pat = Patient.searchPatient(patientId);
        pat.setDue_payment(pat.getDue_payment()- payment);
        stat.executeUpdate("UPDATE patient SET due_payment = '"+pat.getDue_payment()+"' WHERE patient_id = '"+patientId+"'");
        
        stat.executeUpdate("INSERT INTO bill(patient_id,time,date,payment) values ('"+patientId+"','"+time+"','"+date+"','"+payment+"')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM ward");
        result.next();
        
        
        return result.getInt(1);
    }
    
    public static Bill searchBill(int id)throws Exception{
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM bill WHERE bill_id='"+id+"'");
        if(result.next()){
            return new Bill(id,result.getInt(2),result.getString(3),result.getString(4),result.getDouble(5));
        }
        return null;
    }
    
    private int billId;
    private int patientId;
    private String time;
    private String date;
    private double payment;
}
