/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.group2.swing;

import com.group2.ui.DangNhapJDialog;
import com.group2.utils.Auth;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LONG
 */
public class CheckInTest {

    public static DangNhapJDialog dangNhapJDialog;

    @BeforeClass
    public static void setUpClass() {
//        dangNhapJDialog = new DangNhapJDialog();
//        dangNhapJDialog.dangNhap("NV01", "123456");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dangNhapJDialog = new DangNhapJDialog();
        dangNhapJDialog.dangNhap("NV01", "123456");
    }

    @After
    public void tearDown() {
        Auth.clear();
    }

    @Test
    public void testCheckInNotHV() {
        System.out.println("checkIn");
        String input = "0769089058";
        Status instance = new Status();
        instance.checkIn(input);
    }
    
     @Test
    public void testCheckInIsHV() {
        System.out.println("checkIn");
        String input = "0776274144";
        Status instance = new Status();
        instance.checkIn(input);

    }

}
