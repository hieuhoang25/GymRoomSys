/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao.testRunner;

import com.group2.dao.NhanVienTest;
import com.group2.dao.ThongKeDAOTest;
import com.group2.other.DangNhapTest;
import com.group2.swing.CheckInTest;
import com.group2.ui.DoiMatKhauJDailogTest;
import com.group2.ui.TestDangXuat;
import com.group2.utils.ValidationIT;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author lenovo
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(NhanVienTest.class, ThongKeDAOTest.class,
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
