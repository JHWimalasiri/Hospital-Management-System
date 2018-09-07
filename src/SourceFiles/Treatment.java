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
public class Treatment {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public Treatment(int id,int patientId,int docId,String date,String dscp,String result,double payment){
        this.id = id;
        this.patientId = patientId;
        this.docId = docId;
        this.date = date;
        this.dscp = dscp;
        this.result = result;
        this.payment = payment;
        
        
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
     * @return the docId
     */
    public int getDocId() {
        return docId;
    }

    /**
     * @param docId the docId to set
     */
    public void setDocId(int docId) {
        this.docId = docId;
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
     * @return the dscp
     */
    public String getDscp() {
        return dscp;
    }

    /**
     * @param dscp the dscp to set
     */
    public void setDscp(String dscp) {
        this.dscp = dscp;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
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
    
    public int addToDb()throws Exception{
        Statement stat = Db.getStatement();
        Patient pat = Patient.searchPatient(patientId);
        pat.setDue_payment(pat.getDue_payment()+ payment);
        stat.executeUpdate("UPDATE patient SET due_payment = '"+pat.getDue_payment()+"' WHERE patient_id = '"+patientId+"'"); 
        
        stat.executeUpdate("INSERT INTO treatment(patient_id,doc_id,date,description,result,payment) values ('"+patientId+"','"+docId+"','"+date+"','"+dscp+"','"+result+"','"+payment+"')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM ward");
        result.next();
        
        
        return result.getInt(1);
    }
    
    public static Treatment searchTreatment(int id)throws Exception{
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM treatment WHERE id='"+id+"'");
        if(result.next()){
            return new Treatment(id,result.getInt(2),result.getInt(3),result.getString(4),result.getString(5),result.getString(6),result.getDouble(7));
        }
        return null;
    }
    
    public boolean updateTreatment()throws Exception{
        if(searchTreatment(id) == null){
            return false;
        }
            Statement stat = Db.getStatement();
            stat.executeUpdate("UPDATE treatment SET date = '"+date+"',description = '"+dscp+"',result = '"+result+"',payment = '"+payment+"' WHERE id='"+id+"'");
            Patient pat = Patient.searchPatient(patientId);
            pat.setDue_payment(pat.getDue_payment()+ payment);
            stat.executeUpdate("UPDATE patient SET due_payment = '"+pat.getDue_payment()+"' WHERE patient_id = '"+patientId+"'");
        return true;
        
    }
    
    public static boolean deleteTreatment(int id)throws Exception{
        Treatment treat = Treatment.searchTreatment(id);
        if(treat==null){
            return false;
        
        }
        Statement stat = Db.getStatement();
        
        Patient pat = Patient.searchPatient(id);
        pat.setDue_payment(pat.getDue_payment()- treat.getPayment());
        stat.executeUpdate("UPDATE patient SET due_payment = '"+pat.getDue_payment()+"' WHERE patient_id = '"+id+"'");
        stat.executeUpdate("DELETE FROM treatment WHERE id = '"+id+"'");
            
        return true;
    }
    
    private int id;
    private int patientId;
    private int docId;
    private String date;
    private String dscp;
    private String result;
    private double payment;
    
}
