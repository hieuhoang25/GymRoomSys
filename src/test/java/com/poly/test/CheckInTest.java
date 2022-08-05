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

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CheckInTest {

	public static DangNhapJDialog dangNhapJDialog;
	static ArrayList<TestCase> list = new ArrayList<>();

	@BeforeAll
	public static void setUpClass() {
//        dangNhapJDialog = new DangNhapJDialog();
//        dangNhapJDialog.dangNhap("NV01", "123456");
	}

	@AfterAll
	public static void tearDownClass() {
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

	@After
	public void tearDown() {
		Auth.clear();
	}
	static int id =0;
	@ParameterizedTest
	@CsvFileSource(resources = "/checkin.csv", numLinesToSkip = 1)
	public void testCheck(String input, String expected) {
		System.out.println("checkIn");
		id++;
		Status instance = new Status();
		if (expected.equalsIgnoreCase("false")) {
			try {
				Assertions.assertFalse(instance.checkin(input));
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "false", "Fail"));
				Assertions.fail(e);
			}
		} else {
			try {
				Assertions.assertTrue(instance.checkin(input));
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Check in hội viên: boolean checkin(input)", input, "true", "Fail"));
				Assertions.fail(e);
			}
		}

	}

}
