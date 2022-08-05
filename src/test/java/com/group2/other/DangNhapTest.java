/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.other;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import org.junit.*;

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
     */
    @Test()
    public void testDangNhap() {
        System.out.println("TestdangNhap 1");
        String TenDangNhapString = "";
        String MatKhauString = "";
        DangNhapJDialog instance = new DangNhapJDialog();

        try {
            Assert.assertFalse(instance.dangNhapToApp(TenDangNhapString, MatKhauString));
            list.add(new TestCase("TC01", "Đăng nhập với tên đăng nhập hoặc mật khẩu để trống", "username: null; pass:null", "1. Hiển thị thông báo Tên đăng nhập hoặc mật khẩu không chính xác", "Pass"));
        } catch (Exception e) {
            list.add(new TestCase("TC01", "Đăng nhập với tên đăng nhập hoặc mật khẩu để trống", "username: null; pass:null", "1. Hiển thị thông báo Tên đăng nhập hoặc mật khẩu không chính xác", "Fail"));
        }
    }

    @Test
    public void testDangNhap1() {
        System.out.println("TestdangNhap 2");
        String TenDangNhapString = "NV01921";
        String MatKhauString = "2213";
        DangNhapJDialog instance = new DangNhapJDialog();
        try {
            Assert.assertFalse(instance.dangNhapToApp(TenDangNhapString, MatKhauString));
            list.add(new TestCase("Tc02", "Đăng nhập với tên đăng nhập và mật khẩu không tồn tại", "user: NV01921 pass: 2213", "1. Hiển thị thông báo: Tên đăng nhập hoặc mật khẩu không chính xác", "Pass"));
        } catch (Exception e) {
            list.add(new TestCase("Tc02", "Đăng nhập với tên đăng nhập và mật khẩu không tồn tại", "user: NV01921 pass: 2213", "1. Hiển thị thông báo: Tên đăng nhập hoặc mật khẩu không chính xác", "Fail"));

        }
    }

    @Test
    public void testDangNhap2() {
        System.out.println("TestdangNhap 3");
        String TenDangNhapString = "NV01";
        String MatKhauString = "123456";
        DangNhapJDialog instance = new DangNhapJDialog();
        try {
            Assert.assertTrue(instance.dangNhapToApp(TenDangNhapString, MatKhauString));

            list.add(new TestCase("TC03", "Đăng nhập với tài khoản nhân viên", "user: NV01 pass: 123456", "1.Hiển thị thông báo Đăng nhập thành công \n 2.Vào trang chủ dành cho nhân viên", "Pass"));
        } catch (Exception e) {

            list.add(new TestCase("TC03", "Đăng nhập với tài khoản nhân viên", "user: NV01 pass: 123456", "1.Hiển thị thông báo Đăng nhập thành công \n 2.Vào trang chủ dành cho nhân viên", "Fail"));
        }
    }

    @Test
    public void testDangNhap3() {
        System.out.println("TestdangNhap 4");
        String TenDangNhapString = "NV02";
        String MatKhauString = "123456";
        DangNhapJDialog instance = new DangNhapJDialog();
        try {
            Assert.assertTrue(instance.dangNhapToApp(TenDangNhapString, MatKhauString));
            list.add(new TestCase("TC04", "Đăng nhập với tài khoản nhân viên quản lý", "user: NV02, pass: 123456", "1.Hiển thị thông báo Đăng nhập thành công \n 2.Vào trang chủ dành cho quản lý", "Pass"));
        } catch (Exception e) {
            list.add(new TestCase("TC04", "Đăng nhập với tài khoản nhân viên quản lý", "user: NV02, pass: 123456", "1.Hiển thị thông báo Đăng nhập thành công \n 2.Vào trang chủ dành cho quản lý", "Fail"));
        }
    }
}
