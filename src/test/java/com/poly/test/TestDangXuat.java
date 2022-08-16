/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.poly.test;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.entity.NhanVien;
import com.group2.ui.DangNhapJDialog;
import com.group2.ui.GymSysJFrame;
import com.group2.utils.Auth;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author lenovo
 */
public class TestDangXuat {
	static ArrayList<TestCase> list = new ArrayList<>();
	static DangNhapJDialog dangnhap;

	public TestDangXuat() {
	}

	@BeforeClass
	public static void setUpClass() {
		dangnhap = new DangNhapJDialog();
		dangnhap.dangNhap("NV01", "123456");
	}

	@AfterClass
	public static void tearDownClass() {
		try {
			ReportTest.writeExcel(list, "src/books.xlsx", "Chức năng đăng xuất");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testDangxuat() {
		GymSysJFrame main = new GymSysJFrame();
		try {
			main.dangxuat();
			System.out.println("hêlo");
			assertTrue(Auth.user == null ? true : false);
			list.add(new TestCase("TC1", "Đăng xuất: dangxuat()", "", "Auth=null", "Pass"));

		} catch (Throwable e) {
			System.out.println(Auth.user);
			list.add(new TestCase("TC1", "Đăng xuất: dangxuat()", "", "Auth=null", "Fail"));
			fail();
		}

	}
}
