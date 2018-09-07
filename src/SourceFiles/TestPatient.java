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
public class TestPatient {

    /**
     * @return the testPatient_id
     */
    public int getTestPatient_id() {
        return testPatient_id;
    }

    /**
     * @param testPatient_id the testPatient_id to set
     */
    public void setTestPatient_id(int testPatient_id) {
        this.testPatient_id = testPatient_id;
    }

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
     * @return the test_id
     */
    public int getTest_id() {
        return test_id;
    }

    /**
     * @param test_id the test_id to set
     */
    public void setTest_id(int test_id) {
        this.test_id = test_id;
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

    public TestPatient(int testPatient_id, int patient_id, int test_id, String result, String date) {
        this.testPatient_id = testPatient_id;
        this.patient_id = patient_id;
        this.test_id = test_id;
        this.date = date;
        this.result = result;

    }

    public int addToDb() throws Exception {
        Statement stat = Db.getStatement();
        stat.executeUpdate("INSERT INTO testPatient(patient_id,test_id,result,date) values ('" + patient_id + "','" + test_id + "','" + result + "','" + date + "')");
        ResultSet result = stat.executeQuery("SELECT LAST_INSERT_ID() FROM testPatient");
        result.next();

        Test test = Test.searchTest(test_id);
        double pay = test.getPayment();

        Patient pat = Patient.searchPatient(patient_id);
        pat.setDue_payment(pat.getDue_payment() + pay);
        stat.executeUpdate("UPDATE patient SET due_payment = '" + pat.getDue_payment() + "' WHERE patient_id = '" + patient_id + "'");
        return result.getInt(1);
    }

    public static TestPatient searchTestPatient(int id) throws Exception {
        Statement stat = Db.getStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM testPatient WHERE testPatient_id='" + id + "'");
        if (result.next()) {
            return new TestPatient(id, result.getInt(2), result.getInt(3), result.getString(4), result.getString(5));
        }
        return null;
    }

    private int testPatient_id;
    private int patient_id;
    private int test_id;
    private String date;
    private String result;
}
