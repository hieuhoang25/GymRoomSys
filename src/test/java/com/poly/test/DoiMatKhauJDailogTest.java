/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.poly.test;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.ui.DangNhapJDialog;
import com.group2.ui.DoiMatKhauJDailog;
import com.group2.utils.Auth;

/**
 *
 * @author lenovo
 */
public class DoiMatKhauJDailogTest {

	static DangNhapJDialog dangnhap;
	static DoiMatKhauJDailog doiMK;
	static ArrayList<TestCase> list = new ArrayList<>();
	@BeforeEach
	public  void all() {
		dangnhap = new DangNhapJDialog();
        doiMK = new DoiMatKhauJDailog();
	}
	@AfterAll
	public static void save() {
		
		 try {
	            ReportTest.writeExcel(list, "src/books.xlsx", "Chức năng đổi mật khẩu");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
	}
	@AfterEach
	public  void clear() {
		dangnhap = null;
		doiMK = null;
	}
	
	
	// Mật khẩu hiện tại không chính xác
	static int id = 0;

	@ParameterizedTest
	@CsvFileSource(resources = "/doimatkhau.csv", numLinesToSkip = 1)
    public void testDoiMatKhau(String oldpassword,String newpassword1,String newpassword2,String expected,String mavn, String pass) {
		System.out.println("Dổi mật khẩu");
		
	    dangnhap.dangNhapToApp(mavn, pass);
	    System.out.println(Auth.user.getMatKhau());
		id++;
            if (expected.equalsIgnoreCase("false")) {
    			try {
    				Assertions.assertFalse(doiMK.doiMatKhauUser(oldpassword, newpassword1, newpassword2));
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "false", "Pass"));

    			} catch (Throwable e) {
    				// TODO: handle exception
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "false", "Fail"));

    				Assertions.fail(e);
    			}
    		} else {
    			try {
    				Assertions.assertTrue(doiMK.doiMatKhauUser(oldpassword, newpassword1, newpassword2));
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "true", "Pass"));

    			} catch (Throwable e) {
    				// TODO: handle exception
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "true", "Fail"));
    				Assertions.fail(e);
    			}
    		}
    }
}
