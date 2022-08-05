/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.group2.swing;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.ui.DangNhapJDialog;
import com.group2.utils.Auth;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Assertions;


/**
 *
 * @author LONG
 */
public class CheckInTest {

    public static DangNhapJDialog dangNhapJDialog;
   static ArrayList<TestCase> list = new ArrayList<>();

    @BeforeAll
    public static void setUpClass() {
     
    }

    @AfterAll
    public static void tearDownClass()  {
        try {
            ReportTest.writeExcel(list, "src/books.xlsx", "Chức năng check in");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @BeforeEach
    public void setUp() {
        dangNhapJDialog = new DangNhapJDialog();
        dangNhapJDialog.dangNhapToApp("NV01", "123456");
    }

    @AfterEach
    public void tearDown() {
        Auth.clear();
    }
    
    
    @ParameterizedTest
    @CsvFileSource(resources = "/login.csv",numLinesToSkip = 1)
   
    public void testCheckInNotHV(String input, String expected) {
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
