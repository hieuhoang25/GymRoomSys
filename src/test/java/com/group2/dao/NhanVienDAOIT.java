/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.dao;

import com.group2.entity.NhanVien;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author HieuHoang
 */
public class NhanVienDAOIT {
    
    public NhanVienDAOIT() {
    }
    
    
  

    /**
     * Test of insert method, of class NhanVienDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        NhanVien entity = null;
        NhanVienDAO instance = new NhanVienDAO();
        entity.setSoDT("0776274144");
        entity.setMaNV("NV01");
        try {
            instance.insert(entity);
        } catch (Exception e) {
            Assert.fail("Lỗi");
        }
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of update method, of class NhanVienDAO.
     */
   
}
