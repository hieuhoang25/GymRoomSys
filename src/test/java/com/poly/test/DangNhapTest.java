/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.test;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.swing.Status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.group2.ui.DangNhapJDialog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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

    @BeforeAll
    public static void setUpClass() {
        dangNhapJDialog = new DangNhapJDialog();
    }

    @AfterAll
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
    static int id = 0;
	@ParameterizedTest
	@CsvFileSource(resources = "/login.csv", numLinesToSkip = 1)
	public void testCheck(String username,String password, String expected) {
		System.out.println("Dang nhap");
		DangNhapJDialog instance = new DangNhapJDialog();
		id++;
		if (expected.equalsIgnoreCase("false")) {
			try {
				Assertions.assertFalse(instance.dangNhapToApp(username, password));
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "false", "Fail"));
				Assertions.fail(e);
			}
		} else {
			try {
				Assertions.assertTrue(instance.dangNhapToApp(username, password));
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC"+id, "Đăng nhập : boolean dangNhapToApp(username, password)", "username: "+username+", password: "+password, "true", "Fail"));
				Assertions.fail(e);
			}
		}

	}
  
}
