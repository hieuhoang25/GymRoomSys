/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.poly.test;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.swing.Status;
import com.group2.ui.DangNhapJDialog;
import com.group2.utils.Auth;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class CheckInTest {

	public static DangNhapJDialog dangNhapJDialog;
	static ArrayList<TestCase> list = new ArrayList<>();

	@BeforeClass
	public static void setUpClass() {
//        dangNhapJDialog = new DangNhapJDialog();
//        dangNhapJDialog.dangNhap("NV01", "123456");
	}

	@AfterClass
	public static void tearDownClass() {
		try {
			ReportTest.writeExcel(list, "src/books.xlsx", "Chức năng check in");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@BeforeTest
	public void setUp() {
		dangNhapJDialog = new DangNhapJDialog();
		dangNhapJDialog.dangNhapToApp("NV01", "123456");
	}
	@DataProvider(name = "testcase")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "0769089058",false },
	   { "0776274144",true},
	 };
	}
	 

	@AfterTest
	public void tearDown() {
		Auth.clear();
	}
	static int id =0;
	@Test(dataProvider = "testcase")
	public void testCheck(String input, boolean expected) {
		System.out.println("checkIn");
		id++;
		Status instance = new Status();
		if (expected==false) {
			try {
				
				assertFalse(instance.checkin(input));
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "false", "Fail"));
				fail();
			}
		} else {
			try {
				assertTrue(instance.checkin(input));
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "true", "Fail"));
				fail();
			}
		}

	}

}
