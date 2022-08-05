/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.group2.swing;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
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
   static ArrayList<TestCase> list = new ArrayList<>();

    @BeforeAll
    public static void setUpClass() {
//        dangNhapJDialog = new DangNhapJDialog();
//        dangNhapJDialog.dangNhap("NV01", "123456");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    }

    @BeforeEach
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
       
        Status instance = new Status();
        
        try {
        	if (expected.equalsIgnoreCase("false")) {
        		 Assertions.assertFalse(instance.checkin(input));
        	}
        	else {
        		Assertions.assertTrue(instance.checkin(input));
        	}
        
			
          list.add( new TestCase("TC1","Check in hội viên với số điện thoại không "
                    + "phải là hội viên",input,"Thông bá́o: \"Số điện thoại không phải của hội viên\"","Pass"));
        } catch (Exception e) {
           list.add(new TestCase("TC1","Check in hội viên với số điện thoại không phải là hội viên",input,"Thông bá́o: \"Số điện thoại không phải của hội viên\"","Fail"));
       
        }
    }
//    @ParameterizedTest
//    @CsvFileSource(resources = "/login.csv",numLinesToSkip = 1)
//    
//    public void testCheckInIsHV(String input) {
//        System.out.println("checkIn");
//       
//        Status instance = new Status();
//        
//        try {
//         Assertions.assertTrue(instance.checkin(input));
//			
//          list.add( new TestCase("TC1","Check in hội viên với số điện thoại không "
//                    + "phải là hội viên",input,"Thông bá́o: \"Số điện thoại không phải của hội viên\"","Pass"));
//        } catch (Exception e) {
//           list.add(new TestCase("TC1","Check in hội viên với số điện thoại không phải là hội viên",input,"Thông bá́o: \"Số điện thoại không phải của hội viên\"","Fail"));
//       
//        }
//    }
//    @Test
//    public void testCheckInIsHV() {
//        System.out.println("checkIn");
//        String input = "0776274144";
//        Status instance = new Status();
//        try {
//            Assert.assertTrue(instance.checkin(input));
//            
//        list.add( new TestCase("TC2","Check in hội viên với số điện thoại là hội viên","sdt:0776274144","Thông báo: \"Check in thành công\"","Pass"));
//        } catch (Exception e) {
//         list.add (new TestCase("TC2","Check in hội viên với số điện thoại là hội viên","sdt:0776274144","Thông báo: \"Check in thành công\"","Fail"));
//  }
//
//    }

}
