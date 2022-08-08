/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.test;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.swing.Status;

import com.group2.ui.DangNhapJDialog;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author HieuHoang
 */
public class DangNhapTest {

    static ReportTest report;
    public static DangNhapJDialog dangNhapJDialog;
    static ArrayList<TestCase> list = new ArrayList<>();

    public DangNhapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dangNhapJDialog = new DangNhapJDialog();
    }

    @AfterClass
    public static void tearDownClass() {
        try {
            ReportTest.writeExcel(list, "src/books.xlsx", "Chức năng đăng nhập");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of main method, of class DangNhapJDialog.
     */
    /**
     * Test of dangNhap method, of class DangNhapJDialog.
     * 
     */
	@DataProvider(name = "testcase")
	public Iterator<Object[]> createData1() {
		List<Object[]> result = new ArrayList<>();
		result.add(new Object[] {"","" ,false});
		result.add(new Object[] {"NV01921","2213",false});
		result.add(new Object[] {"NV01","123456",true});
		result.add(new Object[] {"NV02","123456",true});
//	 return new Object[][][] {
//	   {  },
//	   { "NV01","123456",true },
//	   {"NV02","123456",true}
		return result.iterator();
	 };
	
    static int id = 0;
    @Test(dataProvider = "testcase")
	public void testCheck(String username,String password, boolean expected) {
		System.out.println("Dang nhap");
		DangNhapJDialog instance = new DangNhapJDialog();
		id++;
		if (expected==false) {
			try {
		
				assertFalse(instance.dangNhapToApp(username, password));
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "false", "Fail"));
				fail();
			}
		} else {
			try {
				assertTrue(instance.dangNhapToApp(username, password));
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "true", "Fail"));
				fail();
			}
		}

	}
  
}
