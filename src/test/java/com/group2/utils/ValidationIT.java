/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.utils;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HieuHoang
 */
public class ValidationIT {

    public ValidationIT() {
    }

    /**
     * Test of checkLength method, of class Validation.
     */
    //input = ""
    @Test
    public void testCheckLength() {
        System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 1 ");
        String str = "";
        boolean expResult = false;
        boolean result = Validation.checkLength(str);
        assertEquals(expResult, result);
    }

    //input: null
    @Test
    public void testCheckLength1() {
        System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 2");
        String str = null;
        boolean expResult = false;
        boolean result = Validation.checkLength(str);
        assertEquals(expResult, result);
    }
    //input: string

    @Test
    public void testCheckLength2() {
        System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 3");
        String str = "string";
        boolean expResult = true;
        boolean result = Validation.checkLength(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkExperession method, of class Validation.
     */


    /**
     * Test of correctString method, of class Validation.
     */
    //chuỗi hợp lệ
    @Test
    public void testCorrectString() {
        System.out.println("correctString");
        String str = "";
        boolean expResult = false;
        boolean result = Validation.correctString(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testCorrectString1() {
        System.out.println("correctString");
        String str = "123";
        boolean expResult = false;
        boolean result = Validation.correctString(str);
        assertEquals(expResult, result);
    }
      @Test
    public void testCorrectString2() {
        System.out.println("correctString");
        String str = "1234567";
        boolean expResult = true;
        boolean result = Validation.correctString(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkInt method, of class Validation.
     */
    //chuyển string sang số nguyên
    @Test
    public void testCheckInt() {
        System.out.println("checkInt");
        String str = "";
        boolean expResult = false;
        boolean result = Validation.checkInt(str);
        assertEquals(expResult, result);
    }
 @Test
    public void testCheckInt1() {
        System.out.println("checkInt");
        String str = "12a";
        boolean expResult = false;
        boolean result = Validation.checkInt(str);
        assertEquals(expResult, result);
    }
     @Test
    public void testCheckInt2() {
        System.out.println("checkInt");
        String str = "12";
        boolean expResult = true;
        boolean result = Validation.checkInt(str);
        assertEquals(expResult, result);
    }
     @Test
    public void testCheckInt3() {
        System.out.println("checkInt");
        String str = "12.2";
        boolean expResult = false;
        boolean result = Validation.checkInt(str);
        assertEquals(expResult, result);
    }
    /**
     * Test of checkDouble method, of class Validation.
     */
    @Test
    public void testCheckDouble() {
        System.out.println("checkDouble");
        String str = "";
        boolean expResult = false;
        boolean result = Validation.checkDouble(str);
        assertEquals(expResult, result);
     
    }
@Test
    public void testCheckDouble1() {
        System.out.println("checkDouble");
        String str = "0.5";
        boolean expResult = true;
        boolean result = Validation.checkDouble(str);
        assertEquals(expResult, result);
      
    }

    @Test
    public void testCheckDouble2() {
        System.out.println("checkDouble");
        String str = "12.5a";
        boolean expResult = false;
        boolean result = Validation.checkDouble(str);
        assertEquals(expResult, result);
       
    }


    /**
     * Test of checkToDate method, of class Validation.
     */
    @Test
    public void testCheckToDate() {
        System.out.println("checkToDate");
        String date = "";
        String regex = "";
        boolean expResult = false;
        boolean result = Validation.checkToDate(date, regex);
        assertEquals(expResult, result);
    }
     @Test
    public void testCheckToDate1() {
        System.out.println("checkToDate");
        String date = "12/05/2001";
        String regex = "dd/MM/yyyy";
        boolean expResult = true;
        boolean result = Validation.checkToDate(date, regex);
        assertEquals(expResult, result);
      
    }
     @Test
    public void testCheckToDate2() {
        System.out.println("checkToDate");
        String date = "12/05/2001";
        String regex = "dd-MM-yyyy";
        boolean expResult = false;
        boolean result = Validation.checkToDate(date, regex);
        assertEquals(expResult, result);
    }
   
   

    /**
     * Test of checkToString method, of class Validation.
     */
    @Test
    public void testCheckToString() {
        System.out.println("checkToString");
        Date date = null;
        String regex = "";
        boolean expResult = false;
        boolean result = Validation.checkToString(date, regex);
        assertEquals(expResult, result);
       
    }
    
      @Test
    public void testCheckToString1() {
        System.out.println("checkToString");
        Date date = new Date();
        String regex = "dd/MM/yyyy";
        boolean expResult = true;
        boolean result = Validation.checkToString(date, regex);
        assertEquals(expResult, result);
       
    }
      @Test
    public void testCheckToString3() {
        System.out.println("checkToString");
        Date date = new Date();
        String regex = "adsffaddas";
        boolean expResult = false;
        boolean result = Validation.checkToString(date, regex);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkName method, of class Validation.
     */
    @Test
    public void testCheckName() {
        System.out.println("checkName");
        String str = "";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.checkName(str);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckName1() {
        System.out.println("checkName");
        String str = "Hiếu Hoàng";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.checkName(str);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckName3() {
        System.out.println("checkName");
        String str = "HieuHoang12";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.checkName(str);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkEmail method, of class Validation.
     */
    @Test
    public void testCheckEmail() {
        System.out.println("checkEmail");
        String str = "";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.checkEmail(str);
        assertEquals(expResult, result);
     
    }
     @Test
    public void testCheckEmail1() {
        System.out.println("checkEmail");
        String str = "";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.checkEmail(str);
        assertEquals(expResult, result);
     
    }
     @Test
    public void testCheckEmail2() {
        System.out.println("checkEmail");
        String str = "hieu com @ gmail";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.checkEmail(str);
        assertEquals(expResult, result);
     
    }
       @Test
    public void testCheckEmail3() {
        System.out.println("checkEmail");
        String str = "hieuhvps19146@fpt.edu.vn";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.checkEmail(str);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of checkDate method, of class Validation.
     */
    @Test
    public void testCheckDate() {
        System.out.println("checkDate");
        String str = "";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.checkDate(str);
        assertEquals(expResult, result);
    
    }
  @Test
    public void testCheckDate2() {
        System.out.println("checkDate");
        String str = "123/45";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.checkDate(str);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckDate3() {
        System.out.println("checkDate");
        String str = "13/05/2001";
        Validation instance = new Validation();
        boolean expResult = true;
        boolean result = instance.checkDate(str);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkMa method, of class Validation.
     */
  

    /**
     * Test of checkNumber method, of class Validation.
     */
   

}
