/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.group2.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.internal.runners.statements.Fail;

/**
 *
 * @author lenovo
 */
public class DoiMatKhauJDailogTest {

    DangNhapJDialog dangnhap;
    DoiMatKhauJDailog doiMK;

    @After
    public void clearInFo() {
        dangnhap = null;
        doiMK = null;
    }

    // Mật khẩu hiện tại không chính xác
    @Test
    public void testDoiMatKhau1() {

            dangnhap = new DangNhapJDialog();
            dangnhap.dangNhap("NV02", "123456");
            doiMK = new DoiMatKhauJDailog();
            doiMK.doiMatKhau("111111", "123456a", "123456a");
          
    }

    // Đổi mật khẩu với mật khẩu hợp lệ
    @Test
    public void testDoiMatKhau2() {
        dangnhap = new DangNhapJDialog();
        dangnhap.dangNhap("NV01", "123456");
        doiMK = new DoiMatKhauJDailog();
        doiMK.doiMatKhau("123456", "123456a", "123456a");
    }

    // Mật khẩu mới không trùng
    @Test
    public void testDoiMatKhau3() {
            dangnhap = new DangNhapJDialog();
            dangnhap.dangNhap("NV03", "123456");
            doiMK = new DoiMatKhauJDailog();
            doiMK.doiMatKhau("123456", "1234567", "123456a");
            Assert.fail("Mật khẩu mới không đúng");
    }

    // mk mới với số kí tự nhỏ hơn 6
    @Test
    public void testDoiMatKhau4() {
            dangnhap = new DangNhapJDialog();
            dangnhap.dangNhap("NV04", "123456");
            doiMK = new DoiMatKhauJDailog();
            doiMK.doiMatKhau("123456", "123", "123");
            Assert.fail("Mật khẩu nhở hơn 6 kí tự");
    }

    // mk mới với số kí tự lớn hơn 14
    @Test
    public void testDoiMatKhau5() {
        try {
            dangnhap = new DangNhapJDialog();
            dangnhap.dangNhap("NV05", "123456a");
            doiMK = new DoiMatKhauJDailog();
            doiMK.doiMatKhau("123456", "0123456789zxcvf", "0123456789zxcvf");
        } catch (Exception e) {
            Assert.fail("Mật khẩu lớn hơn 14 kí tự");
        }
    }
}
