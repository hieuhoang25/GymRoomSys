/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;
import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.ui.DangNhapJDialog;
import com.group2.utils.Validation;

/**
 *
 * @author HieuHoang
 */
public class ValidationIT {
	static ArrayList<TestCase> list = new ArrayList<>();

	public ValidationIT() {
	}

	@BeforeClass
	public static void setUpClass() {

	}

	@AfterClass
	public static void tearDownClass() {
		try {
			ReportTest.writeExcel(list, "src/books.xlsx", "Validation");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Test of checkLength method, of class Validation.
	 */
	// input = ""
	@Test
	public void testCheckLength() {
		System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 1 ");
		String str = "";
		boolean expResult = false;
		boolean result = Validation.checkLength(str);
		assertEquals(expResult, result);
	}

	// input: null
	@Test
	public void testCheckLength1() {
		System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 2");
		String str = null;
		boolean expResult = false;
		boolean result = Validation.checkLength(str);
		assertEquals(expResult, result);
	}
	// input: string

	@Test
	public void testCheckLength2() {
		System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 3");
		String str = "string";
		boolean expResult = true;
		boolean result = Validation.checkLength(str);
		assertEquals(expResult, result);
	}

	/**
	 * Test of checkExperession method, of class Validation.
	 */

	/**
	 * Test of correctString method, of class Validation.
	 */
	// chuỗi hợp lệ
	@Test
	public void testCorrectString() {
		System.out.println("correctString");
		String str = "";
		boolean expResult = false;
		boolean result = Validation.correctString(str);
		assertEquals(expResult, result);
	}

	@Test
	public void testCorrectString1() {
		System.out.println("correctString");
		String str = "123";
		boolean expResult = false;
		boolean result = Validation.correctString(str);
		assertEquals(expResult, result);
	}

	@Test
	public void testCorrectString2() {
		System.out.println("correctString");
		String str = "1234567";
		boolean expResult = true;
		boolean result = Validation.correctString(str);
		assertEquals(expResult, result);
	}

	/**
	 * Test of checkInt method, of class Validation.
	 */
	@DataProvider(name = "StringToInt")
	public Object[][] data1() {
		return new Object[][] { { "", false }, { "12a", false }, { "12", true } };
	}

	// chuyển string sang số nguyên
	static int id = 0;

	@Test(dataProvider = "StringToInt")
	public void testCheckInt(String input, boolean expected) {
		System.out.println("checkInt");
		id++;
		if (expected = false) {
			try {
				assertFalse(Validation.checkInt(input));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "false", "Pass"));
				fail();
			}
		} else {
			try {
				assertTrue(Validation.checkInt(input));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "true", "Fail"));
				fail();
			}
		}
	}

	/**
	 * Test of checkDouble method, of class Validation.
	 */

	@DataProvider(name = "StringToDouble")
	public Object[][] data2() {
		return new Object[][] { { "", false }, { "12.5a", false }, { "0.5", true } };
	}

	@Test(dataProvider = "StringToDouble")
	public void testCheckDouble(String input, boolean expected) {
		System.out.println("checkDouble");
		id++;
		if (expected==false) {
			try {
				assertFalse(Validation.checkDouble(input));
				list.add(
						new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
								"input: " + input, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(
						new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
								"input: " + input, "false", "Pass"));
				fail();
			}
		} else {
			try {
				assertTrue(Validation.checkDouble(input));
				list.add(
						new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
								"input: " + input, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(
						new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
								"input: " + input, "true", "Fail"));
				fail();
			}
		}

	}

	/**
	 * Test of checkToDate method, of class Validation.
	 */
	@DataProvider(name = "StringToDate")
	public Iterator<Object[]> data3() {
		List<Object[]> result = new ArrayList<>();
		result.add(new Object[] { "", "", false });
		result.add(new Object[] { "12/05/2001", "dd/MM/yyyy", true });
		result.add(new Object[] { "12/05/2001", "dd-MM-yyyy", false });
		return result.iterator();
	}

	@Test(dataProvider = "StringToDate")
	public void testCheckToDate(String input, String regex, boolean expected) {
		System.out.println("checkToDate");
		id++;
		if (expected = false) {
			try {
				assertFalse(Validation.checkToDate(input, regex));
				list.add(new TestCase("TC" + id,
						"Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input + ", regex: " + regex, "false", "Pass"));

			} catch (Exception e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id,
						"Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input + ", regex: " + regex, "false", "Pass"));
				fail();
			}
		} else {
			try {
				assertTrue(Validation.checkToDate(input, regex));
				list.add(new TestCase("TC" + id,
						"Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input + ", regex: " + regex, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id,
						"Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input + ", regex: " + regex, "true", "Fail"));
				fail();
			}
		}

	}

	/**
	 * Test of checkToString method, of class Validation.
	 */
	@Test
	public void testCheckToString() {
		System.out.println("checkToString");
		Date date = null;
		String regex = "";
		boolean expResult = false;
		boolean result = Validation.checkToString(date, regex);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckToString1() {
		System.out.println("checkToString");
		Date date = new Date();
		String regex = "dd/MM/yyyy";
		boolean expResult = true;
		boolean result = Validation.checkToString(date, regex);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckToString3() {
		System.out.println("checkToString");
		Date date = new Date();
		String regex = "adsffaddas";
		boolean expResult = false;
		boolean result = Validation.checkToString(date, regex);
		assertEquals(expResult, result);

	}

	/**
	 * Test of checkName method, of class Validation.
	 */
	@Test
	public void testCheckName() {
		System.out.println("checkName");
		String str = "";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkName(str);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckName1() {
		System.out.println("checkName");
		String str = "Hiếu Hoàng";
		Validation instance = new Validation();
		boolean expResult = true;
		boolean result = instance.checkName(str);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckName3() {
		System.out.println("checkName");
		String str = "HieuHoang12";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkName(str);
		assertEquals(expResult, result);

	}

	/**
	 * Test of checkEmail method, of class Validation.
	 */
	@Test
	public void testCheckEmail() {
		System.out.println("checkEmail");
		String str = "";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkEmail(str);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckEmail1() {
		System.out.println("checkEmail");
		String str = "";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkEmail(str);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckEmail2() {
		System.out.println("checkEmail");
		String str = "hieu com @ gmail";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkEmail(str);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckEmail3() {
		System.out.println("checkEmail");
		String str = "hieuhvps19146@fpt.edu.vn";
		Validation instance = new Validation();
		boolean expResult = true;
		boolean result = instance.checkEmail(str);
		assertEquals(expResult, result);

	}

	/**
	 * Test of checkDate method, of class Validation.
	 */
	@Test
	public void testCheckDate() {
		System.out.println("checkDate");
		String str = "";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkDate(str);
		assertEquals(expResult, result);

	}

	@Test
	public void testCheckDate2() {
		System.out.println("checkDate");
		String str = "123/45";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkDate(str);
		assertEquals(expResult, result);
	}

	@Test
	public void testCheckDate3() {
		System.out.println("checkDate");
		String str = "13/05/2001";
		Validation instance = new Validation();
		boolean expResult = true;
		boolean result = instance.checkDate(str);
		assertEquals(expResult, result);
	}

	/**
	 * Test of checkMa method, of class Validation.
	 */

	/**
	 * Test of checkNumber method, of class Validation.
	 */

}
