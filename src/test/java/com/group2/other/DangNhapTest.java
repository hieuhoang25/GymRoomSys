/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.other;

import org.testng.annotations.*;

import com.group2.ui.DangNhapJDialog;


/**
 *
 * @author HieuHoang
 */
public class DangNhapTest {

    public static DangNhapJDialog dangNhapJDialog;

    public DangNhapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dangNhapJDialog = new DangNhapJDialog();
    }

    @AfterClass
    public static void tearDownClass() {
    }

   


    /**
     * Test of main method, of class DangNhapJDialog.
     */
   

    /**
     * Test of dangNhap method, of class DangNhapJDialog.
     */
    @Test
    public void testDangNhap() {
        System.out.println("TestdangNhap 1");
        String TenDangNhapString = "";
        String MatKhauString = "";
        DangNhapJDialog instance = new DangNhapJDialog();
        instance.dangNhap(TenDangNhapString, MatKhauString);
       
    }
    @Test
    public void testDangNhap1() {
        System.out.println("TestdangNhap 2");
        String TenDangNhapString = "NV01921";
        String MatKhauString = "2213";
        DangNhapJDialog instance = new DangNhapJDialog();
        instance.dangNhap(TenDangNhapString, MatKhauString);
    }
    @Test
    public void testDangNhap2() {
        System.out.println("TestdangNhap 3");
        String TenDangNhapString = "NV01";
        String MatKhauString = "123456";
        DangNhapJDialog instance = new DangNhapJDialog();
        instance.dangNhap(TenDangNhapString, MatKhauString);
    }
    @Test
    public void testDangNhap3() {
        System.out.println("TestdangNhap 4");
        String TenDangNhapString = "NV02";
        String MatKhauString = "123456";
        DangNhapJDialog instance = new DangNhapJDialog();
        instance.dangNhap(TenDangNhapString, MatKhauString);
    }
}
