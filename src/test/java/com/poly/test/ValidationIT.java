/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.group2.config.ReportTest;
import com.group2.config.TestCase;
import com.group2.ui.DangNhapJDialog;
import com.group2.utils.Validation;

import org.junit.jupiter.api.Assertions;

/**
 *
 * @author HieuHoang
 */
public class ValidationIT {
	static ArrayList<TestCase> list = new ArrayList<>();

	public ValidationIT() {
	}

	@BeforeAll
	public static void setUpClass() {

	}

	@AfterAll
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
		Assertions.assertEquals(expResult, result);
	}

	// input: null
	@Test
	public void testCheckLength1() {
		System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 2");
		String str = null;
		boolean expResult = false;
		boolean result = Validation.checkLength(str);
		Assertions.assertEquals(expResult, result);
	}
	// input: string

	@Test
	public void testCheckLength2() {
		System.out.println("Kiểm tra hàm kiểm tra độ dài chuổi 3");
		String str = "string";
		boolean expResult = true;
		boolean result = Validation.checkLength(str);
		Assertions.assertEquals(expResult, result);
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
		Assertions.assertEquals(expResult, result);
	}

	@Test
	public void testCorrectString1() {
		System.out.println("correctString");
		String str = "123";
		boolean expResult = false;
		boolean result = Validation.correctString(str);
		Assertions.assertEquals(expResult, result);
	}

	@Test
	public void testCorrectString2() {
		System.out.println("correctString");
		String str = "1234567";
		boolean expResult = true;
		boolean result = Validation.correctString(str);
		Assertions.assertEquals(expResult, result);
	}

	/**
	 * Test of checkInt method, of class Validation.
	 */
	// chuyển string sang số nguyên
	static int id = 0;

	@ParameterizedTest
	@CsvFileSource(resources = "/ValidateStringToInt.csv", numLinesToSkip = 1)
	public void testCheckInt(String input, String expected) {
		System.out.println("checkInt");
		id++;
		if (expected.equalsIgnoreCase("false")) {
			try {
				Assertions.assertFalse(Validation.checkInt(input));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "false", "Pass"));
				Assertions.fail(e);
			}
		} else {
			try {
				Assertions.assertTrue(Validation.checkInt(input));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số nguyên : boolean checkInt(input)",
						"input: " + input, "true", "Fail"));
				Assertions.fail(e);
			}
		}
	}





	/**
	 * Test of checkDouble method, of class Validation.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/ValidateStringToDouble.csv", numLinesToSkip = 1)
	public void testCheckDouble(String input, String expected) {
		System.out.println("checkDouble");
		id++;
		if (expected.equalsIgnoreCase("false")) {
			try {
				Assertions.assertFalse(Validation.checkDouble(input));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
						"input: " + input, "false", "Pass"));

			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
						"input: " + input, "false", "Pass"));
				Assertions.fail(e);
			}
		} else {
			try {
				Assertions.assertTrue(Validation.checkDouble(input));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
						"input: " + input, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là số thực : boolean checkDouble(input)",
						"input: " + input, "true", "Fail"));
				Assertions.fail(e);
			}
		}

	}



	/**
	 * Test of checkToDate method, of class Validation.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/ValidateStringToDate.csv", numLinesToSkip = 1)
	public void testCheckToDate(String input,String regex,String expected) {
		System.out.println("checkToDate");
		id++;
		if (expected.equalsIgnoreCase("false")) {
			try {
				Assertions.assertFalse(Validation.checkToDate(input, regex));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input+", regex: "+regex, "false", "Pass"));

			} catch (Exception e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input+", regex: "+regex, "false", "Pass"));
			}
		} else {
			try {
				Assertions.assertTrue(Validation.checkToDate(input, regex));
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input+", regex: "+regex, "true", "Pass"));
			} catch (Throwable e) {
				// TODO: handle exception
				list.add(new TestCase("TC" + id, "Kiểm tra chuổi có phải là định dạng ngày không : boolean checkToDate(input, regex)",
						"input: " + input+", regex: "+regex, "true", "Fail"));
				Assertions.fail(e);
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
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckToString1() {
		System.out.println("checkToString");
		Date date = new Date();
		String regex = "dd/MM/yyyy";
		boolean expResult = true;
		boolean result = Validation.checkToString(date, regex);
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckToString3() {
		System.out.println("checkToString");
		Date date = new Date();
		String regex = "adsffaddas";
		boolean expResult = false;
		boolean result = Validation.checkToString(date, regex);
		Assertions.assertEquals(expResult, result);

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
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckName1() {
		System.out.println("checkName");
		String str = "Hiếu Hoàng";
		Validation instance = new Validation();
		boolean expResult = true;
		boolean result = instance.checkName(str);
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckName3() {
		System.out.println("checkName");
		String str = "HieuHoang12";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkName(str);
		Assertions.assertEquals(expResult, result);

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
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckEmail1() {
		System.out.println("checkEmail");
		String str = "";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkEmail(str);
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckEmail2() {
		System.out.println("checkEmail");
		String str = "hieu com @ gmail";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkEmail(str);
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckEmail3() {
		System.out.println("checkEmail");
		String str = "hieuhvps19146@fpt.edu.vn";
		Validation instance = new Validation();
		boolean expResult = true;
		boolean result = instance.checkEmail(str);
		Assertions.assertEquals(expResult, result);

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
		Assertions.assertEquals(expResult, result);

	}

	@Test
	public void testCheckDate2() {
		System.out.println("checkDate");
		String str = "123/45";
		Validation instance = new Validation();
		boolean expResult = false;
		boolean result = instance.checkDate(str);
		Assertions.assertEquals(expResult, result);
	}

	@Test
	public void testCheckDate3() {
		System.out.println("checkDate");
		String str = "13/05/2001";
		Validation instance = new Validation();
		boolean expResult = true;
		boolean result = instance.checkDate(str);
		Assertions.assertEquals(expResult, result);
	}

	/**
	 * Test of checkMa method, of class Validation.
	 */

	/**
	 * Test of checkNumber method, of class Validation.
	 */

}
