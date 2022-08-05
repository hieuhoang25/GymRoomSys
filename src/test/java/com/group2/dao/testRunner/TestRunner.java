/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao.testRunner;

import com.group2.dao.NhanVienTest;
import com.group2.dao.ThongKeDAOTest;
import com.poly.test.CheckInTest;
import com.poly.test.DangNhapTest;
import com.poly.test.DoiMatKhauJDailogTest;
import com.poly.test.TestDangXuat;
import com.poly.test.ValidationIT;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author lenovo
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(
              DangNhapTest.class, CheckInTest.class, DoiMatKhauJDailogTest.class,
                TestDangXuat.class, ValidationIT.class);
        for (Failure failure : result.getFailures()) {
            System.out.println("fall: " + failure.toString());
            System.out.println("fall class: " + failure.getClass());
            System.out.println("fall mess: " + failure.getMessage());
            System.out.println("fall Header: " + failure.getTestHeader());

        }
        System.out.println("Result == " + result.wasSuccessful());
    }
}
