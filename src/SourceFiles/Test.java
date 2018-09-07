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
public class Test {

    /**
     * @return the testId
     */
    public int getTestId() {
        return testId;
    }

    /**
     * @param testId the testId to set
     */
    public void setTestId(int testId) {
        this.testId = testId;
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Test(int testId, double payment, String description){
       this.testId = testId;
       this.payment = payment;
       this.description = description;
    }
    
    public int addToDb()throws Exception{
        Statement stat = Db.getStatement();
        stat.executeUpdate("INSERT INTO test(test_id,amount,description) values ('"+testId+"','"+payment+"','"+description+"')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM test");
        result.next();
        return result.getInt(1);
    }
    
    public static Test searchTest(int id)throws Exception{
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM test WHERE test_id='"+id+"'");
        if(result.next()){
            return new Test(id,result.getDouble(2),result.getString(3));
        }
        return null;
    }
    
    public boolean updateTest()throws Exception{
        if(searchTest(testId) == null){
            return false;
        }
            Statement stat = Db.getStatement();
            stat.executeUpdate("UPDATE treatment SET amount = '"+payment+"',description = '"+description+"' WHERE test_id='"+testId+"'");
        return true;
        
    }
    
    public static boolean deleteTest(int id)throws Exception{
        Test treat = Test.searchTest(id);
        if(treat==null){
            return false;
        
        }
        Statement stat = Db.getStatement();
        stat.executeUpdate("DELETE FROM test WHERE test_id = '"+id+"'");
            
        return true;
    }
    
    private int testId;
    private double payment;
    private String description;
}
