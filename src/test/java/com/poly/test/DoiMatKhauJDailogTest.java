/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.poly.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	@BeforeTest
	public  void all() {
		dangnhap = new DangNhapJDialog();
        doiMK = new DoiMatKhauJDailog();
	}
	@AfterClass
	public static void save() {
		
		 try {
	            ReportTest.writeExcel(list, "src/books.xlsx", "Chức năng đổi mật khẩu");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
	}
	@AfterTest
	public  void clear() {
		dangnhap = null;
		doiMK = null;
	}
	@DataProvider(name = "testcase")
	public Iterator<Object[]> data(){
		List<Object[]> result = new ArrayList<>();
		result.add(new Object[] {"111111","123456a","123456a",false,"NV01","123456"});
		result.add(new Object[] {"123456","1234567","123456a",false,"NV01","123456"});
		result.add(new Object[] {"123456","123","123",false,"NV01","123456"});
		result.add(new Object[] {"123456","0123456789zxcvf","0123456789zxcvf",false,"NV04","123456"});
		result.add(new Object[] {"123456","123456a","123456a",true,"NV04","123456"});
		return result.iterator();
	}
	static int id = 0;
	@Test(dataProvider = "testcase")
    public void testDoiMatKhau(String oldpassword,String newpassword1,String newpassword2,boolean expected,String mavn, String pass) {
		System.out.println("Dổi mật khẩu");
	    dangnhap.dangNhapToApp(mavn, pass);
	    System.out.println(Auth.user.getMatKhau());
		id++;
            if (expected==false) {
    			try {
    				assertFalse(doiMK.doiMatKhauUser(oldpassword, newpassword1, newpassword2));
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "false", "Pass"));
    			} catch (Throwable e) {
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "false", "Fail"));
    				fail();
    			}
    		} else {
    			try {
    				assertTrue(doiMK.doiMatKhauUser(oldpassword, newpassword1, newpassword2));
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "true", "Pass"));
    			} catch (Throwable e) {
    				list.add(new TestCase("TC"+id, "Đổi mật khẩu : boolean doiMatKhuUser(oldpassword, newpassword1, newpassword2)", "oldpassword: "+oldpassword+", newpassword1: "+newpassword1+", newpassword2: "+newpassword2+"\n"+"Ma NV: "+mavn+", pass: "+pass, "true", "Fail"));
    				fail();
    			}
    		}
    }
}
