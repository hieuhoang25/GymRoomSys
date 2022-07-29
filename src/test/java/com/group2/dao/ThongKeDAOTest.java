/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.SanPham;
import com.group2.entity.ThongKe;
import com.group2.utils.GDate;
import com.group2.utils.GJDBC;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LONG
 */
public class ThongKeDAOTest {

    public static ThongKeDAO tkDao = new ThongKeDAO();
    public static SanPhamDAO spDao = new SanPhamDAO();
     public static HoaDonCTDAO hdctDao = new HoaDonCTDAO();

 

    @BeforeClass
    public static void setUpClass() {
      
        GJDBC.dburl = "jdbc:sqlserver://localhost:1433;databaseName=GymSysTest";
        System.out.println(GJDBC.dburl);
        
        hdctDao.themHoaDonGoiTap("0355321123", "NV01", "", "Nguyen kIEN", "", GDate.toDate("13/10/2020", "dd/MM/yyy"), 1, "", "", "");
        hdctDao.themHDCTGoiTap("boxing3m", "0355321123", 12000);
        hdctDao.themKHVaHD("0253631256", "NV01", "Hoang AN", "", "", GDate.toDate("13/10/2020", "dd/MM/yyy"), 1, "", "");
        hdctDao.themSPVaoHD("12345668", 5, 35000f);
        
        hdctDao.themKHVaHD("0969885361", "NV01", "Kiem Suong", "", "", GDate.toDate("13/10/2020", "dd/MM/yyy"), 1, "", "");
        hdctDao.themSPVaoHD("12345668", 5, 35000f);
      
        
    }

    @AfterClass
    public static void tearDownClass() {
         String sql =  "delete from KhachHang";
       
         try {
            GJDBC.query(sql);
        } catch (Exception e) {
            System.out.println("testThongKeKhachHang" + e.getMessage());
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    

    @Test
    public void testThongKeGoiTapTheoThang() {
        System.out.println("thongKeGoiTapTheoThang");
        int Thang = 7;
        int Nam = 2022;
        ThongKeDAO instance = new ThongKeDAO();
        Double expResult = 12000.0;
      
        Double result = instance.thongKeGoiTapTheoThang(Thang, Nam);
        
        assertEquals(expResult, result);
      
    }
//
    @Test
    public void testThongKeSanPhamTheoThang() {
        System.out.println("thongKeSanPhamTheoThang");
        int Thang = 7;
        int Nam = 2022;
        ThongKeDAO instance = new ThongKeDAO();
        Double expResult = 70000.0;
        Double result = instance.thongKeSanPhamTheoThang(Thang, Nam);
        assertEquals(expResult, result);
      
    }
//
    @Test
    public void testThongKeKhachHang() {
        
        System.out.println("thongKeKhachHang");
            
        ThongKeDAO instance = new ThongKeDAO();
        Integer expResult = 3;
         Integer result = instance.thongKeKhachHang();
        assertEquals(expResult, result);
        
       

    }
//
    @Test
    public void testThongKeHoiVien() {
        System.out.println("thongKeHoiVien");
        ThongKeDAO instance = new ThongKeDAO();
        Integer expResult = 1;
         Integer result = instance.thongKeHoiVien();
         
        assertEquals(expResult, result);
        
       
    }

}
