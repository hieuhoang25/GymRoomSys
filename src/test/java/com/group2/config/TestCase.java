/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.config;

/**
 *
 * @author HieuHoang
 */
public class TestCase {

    private String id;
    private String description;
    private String testdata;
    private String expected;
    private String pf;
    public TestCase(){
        
    }
    public TestCase(String id, String description, String testdata, String expected, String pf){
           this.id =  id;
           this.description =  description;
           this.testdata =  testdata;
           this.expected =  expected;
           this.pf =  pf;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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

    /**
     * @return the testdata
     */
    public String getTestdata() {
        return testdata;
    }

    /**
     * @param testdata the testdata to set
     */
    public void setTestdata(String testdata) {
        this.testdata = testdata;
    }

    /**
     * @return the expected
     */
    public String getExpected() {
        return expected;
    }

    /**
     * @param expected the expected to set
     */
    public void setExpected(String expected) {
        this.expected = expected;
    }

    /**
     * @return the pf
     */
    public String getPf() {
        return pf;
    }

    /**
     * @param pf the pf to set
     */
    public void setPf(String pf) {
        this.pf = pf;
    }

}
