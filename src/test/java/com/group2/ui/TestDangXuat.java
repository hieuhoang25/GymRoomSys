/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.group2.ui;

import com.group2.entity.NhanVien;
import com.group2.utils.Auth;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lenovo
 */
public class TestDangXuat {
    
    public TestDangXuat() {
    }

    @Test
    public void testDangxuat() {
        //Auth.user = new NhanVien("NV04", "123456", "Nguyễn Tài Nguyên", "Nhân viên", "NV04.png", "45 Đống Đa Hà Nội", 1999-09-23);
        DangNhapJDialog dangnhap = new DangNhapJDialog();
        dangnhap.dangNhap("NV04", "123456");
        GymSysJFrame main = new GymSysJFrame();
        main.dangxuat();
        assertNull(Auth.user);
    }    
}
