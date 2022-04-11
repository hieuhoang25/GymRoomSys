/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.HDCTSanPham;
import com.group2.entity.KhachHang;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class KhachHangDAO extends GymSysDAO<KhachHang, Object> {

    final String INSERT_SQL = "INSERT INTO KhachHang (SoDT, HoTen, DiaChi, NgaySinh, GioiTinh, Hinh, Email)  VALUES  (?, ?, ?, ?, ?, ?,?)";
    final String UPDATE_SQL = "UPDATE  KhachHang  SET SoDT = ? ,  HoTen=?, DiaChi=? , NgaySinh=? , GioiTinh=?, Hinh=?, Email=? where SoDT = ?";
    final String DELETE_SQL = "DELETE FROM KhachHang WHERE SoDT=?";
    final String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    final String SELECT_BY_ID_SQL = "SELECT * FROM KhachHang WHERE SoDT=?";

    @Override
    public void insert(KhachHang entity) {
        GJDBC.update(INSERT_SQL, entity.getSoDT(), entity.getHoTen(), entity.getDiaChi(), entity.getNgaySinh(),
                entity.isGioiTinh(), entity.getHinh(),entity.getEmail());
    }

    @Override
    public void update(KhachHang entity) {
        GJDBC.update(UPDATE_SQL,entity.getSoDT(), entity.getHoTen(), entity.getDiaChi(), entity.getNgaySinh(),
                entity.isGioiTinh(), entity.getHinh(), entity.getEmail(), entity.getSoDT());
    }

    @Override
    public void delete(Object id) {
        GJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectById(Object id) {
        List<KhachHang> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectBySql(String sqlString, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = GJDBC.query(sqlString, args);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setSoDT(rs.getString("SoDT").trim());
                kh.setHoTen(rs.getString("HoTen"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setHinh(rs.getString("Hinh"));
                kh.setEmail(rs.getString("Email")+"");
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<KhachHang> timKhachHang(String... args) {
        String sql = "select * from KhachHang where SoDT like ? or HoTen like ?";
        return selectBySql(sql, args);
    }

    public List<KhachHang> selectNotInCourse(String keyword) {
        String sql = "select * from KhachHang where SoDT = ?";
        return this.selectBySql(sql, keyword);
    }

    public List<KhachHang> getListEmail() {
        String sql = "select * from KhachHang join HoiVien\n"
                + "on KhachHang.SoDT = HoiVien.SoDT";
        return  selectBySql(sql);
    }
    
}
