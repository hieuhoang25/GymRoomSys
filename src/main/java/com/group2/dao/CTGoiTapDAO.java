/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.CTGoiTap;
import com.group2.swing.CTGoiTapModel;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class CTGoiTapDAO extends GymSysDAO<CTGoiTap, Object> {

    final String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    final String SELECT_BY_ID_SQL = "SELECT * FROM KhachHang WHERE SoDT=?";

    @Override
    public void insert(CTGoiTap entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CTGoiTap entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CTGoiTap> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public CTGoiTap selectById(Object id) {
        List<CTGoiTap> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CTGoiTap> selectBySql(String sqlString, Object... args) {
        List<CTGoiTap> list = new ArrayList<>();
        try {
            ResultSet rs = GJDBC.query(sqlString, args);
            while (rs.next()) {
                CTGoiTap ctgt = new CTGoiTap();
                ctgt.setID(rs.getInt("ID"));
                ctgt.setMaGT(rs.getString("MaGT").trim());
                ctgt.setNgayDangKi(rs.getDate("NgayDangKi"));
                ctgt.setNgayHetHan(rs.getDate("NgayHeHan"));
                list.add(ctgt);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<CTGoiTapModel> SelectAllGoiTap(String sql, String ID) {
        List<CTGoiTapModel> list = new ArrayList<>();
        try {
            ResultSet rs = GJDBC.query(sql, ID);
            while (rs.next()) {
                CTGoiTapModel ctgtModel = new CTGoiTapModel();
                ctgtModel.setMaGT(rs.getString("MaGT").trim());
                ctgtModel.setLoaiGT(rs.getString("TenLoai"));
                ctgtModel.setTenGoiTap(rs.getString("TenGoiTap"));
                ctgtModel.setNgayDK(rs.getDate("NgayDangKi"));
                ctgtModel.setNgayHH(rs.getDate("NgayHetHan"));
                list.add(ctgtModel);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<CTGoiTapModel> getCTGoiTap(String ID) {
        String sql = " select GoiTap.MaGT, GoiTap.TenGoiTap, LoaiGoi.TenLoai, CTGoiTap.NgayDangKi, CTGoiTap.NgayHetHan\n"
                + " from GoiTap join CTGoiTap  on GoiTap.MaGT = CTGoiTap.MaGT \n"
                + " join LoaiGoi on GoiTap.MaLoai = LoaiGoi.MaLoai\n"
                + " where ID = ?";
        return SelectAllGoiTap(sql, ""+ID);    
  
    }

}
