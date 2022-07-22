/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.dao;



import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author HieuHoang
 */
public class ThongKeDAOIT {
    
    public ThongKeDAOIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getHVCheckIn method, of class ThongKeDAO.
     */
    
    @Test
    public void testThongKeKhachHang() {
        System.out.println("thongKeKhachHang");
        ThongKeDAO instance = new ThongKeDAO();
        Integer expResult = null;
        Integer result = instance.thongKeKhachHang();
        assertEquals(34, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of thongKeHoiVien method, of class ThongKeDAO.
     */
    
}
