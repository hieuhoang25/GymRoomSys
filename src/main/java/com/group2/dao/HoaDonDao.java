/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.HoaDon;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LONG
 */
public class HoaDonDao {
    String SELECT_ALL = "select * from Hoadon";
    String SELECT_BY_MAKH ="select MaHD, ThoiGianMua from HoaDon where MaKh = ?";
    
    public List<HoaDon> selectBySql(String sqlString, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs =GJDBC.query(sqlString, args);
            while (rs.next()) {                
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setThoiGianMua(rs.getDate("ThoiGianMua"));
                hd.setGhiChu(rs.getString("GhiChu"));
                list.add(hd);         
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return list;
    }
    
    public List<HoaDon> selectByMaKH(Object id) {
        return selectBySql(SELECT_BY_MAKH, id);
    }
    
}
