/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

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
public class DoiMatKhauJDailogIT {
    public static DangNhapJDialog dangNhapJDialog;
    public DoiMatKhauJDailogIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dangNhapJDialog = new DangNhapJDialog();
        dangNhapJDialog.dangNhap("NV01", "12345678");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of check method, of class DoiMatKhauJDailog.
     */
//    @Test
//    public void testCheck() {
//        System.out.println("check");
//        String txtMatKhauCu = "";
//        String txtMatKhauMoi1 = "";
//        String txtMatKhauMoi2 = "";
//        DoiMatKhauJDailog instance = new DoiMatKhauJDailog();
//        boolean expResult = false;
//        boolean result = instance.check(txtMatKhauCu, txtMatKhauMoi1, txtMatKhauMoi2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of doiMatKhau method, of class DoiMatKhauJDailog.
     */
    @Test
    public void testDoiMatKhau() {
        System.out.println("doiMatKhau");
        String txtMatKhauCu = "12345678";
        String txtMatKhauMoi1 = "123456";
        String txtMatKhauMoi2 = "123456";
        DoiMatKhauJDailog instance = new DoiMatKhauJDailog();
        try {
              instance.doiMatKhau(txtMatKhauCu, txtMatKhauMoi1, txtMatKhauMoi2);
        } catch (Exception e) {
          
        }
      
        // TODO review the generated test code and remove the default call to fail.
  
    }
    
}
