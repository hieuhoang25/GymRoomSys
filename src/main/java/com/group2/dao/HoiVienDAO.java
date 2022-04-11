/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.HoiVien;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class HoiVienDAO extends GymSysDAO<HoiVien, String> {

    final String INSERT_SQL = "INSERT INTO  HoiVien (MaNV, SoDT)  VALUES  (?, ?)";
    final String UPDATE_SQL = "UPDATE  HoiVien  SET  MaNV = ?, SoDT = ? WHERE  ID=?";
    final String DELETE_SQL = "DELETE FROM HoiVien WHERE ID=?";
    final String SELECT_ALL_SQL = "SELECT HoiVien.ID, KhachHang.HoTen, KhachHang.SoDT, KhachHang.DiaChi, HoiVien.MaNV"
            + " FROM HoiVien join KhachHang on HoiVien.SoDT = KhachHang.SoDT";
    final String SELECT_BY_ID_SQL = "Select * from HoiVien where MaHV = ?";
    final String SELECT_BY_SDT_SQL = "Select * from HoiVien where SoDT = ?";

    @Override
    public void insert(HoiVien entity) {
        GJDBC.update(INSERT_SQL, entity.getID(), entity.getMaNV(), entity.getSoDT());
    }

    @Override
    public void update(HoiVien entity) {
        GJDBC.update(UPDATE_SQL, entity.getSoDT(), entity.getID());
    }

    @Override
    public void delete(String id) {
        GJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<HoiVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoiVien selectById(String id) {
        List<HoiVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public HoiVien selectBySDT(String sdt) {
        List<HoiVien> list = selectBySql(SELECT_BY_SDT_SQL, sdt);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoiVien> selectBySql(String sqlString, Object... args) {
        List<HoiVien> list = new ArrayList<>();
        try {
            ResultSet rs = GJDBC.query(sqlString, args);
            while (rs.next()) {
                HoiVien hv = new HoiVien();
                hv.setID(rs.getInt("ID"));
                hv.setMaNV(rs.getString("MaNV"));
                hv.setSoDT(rs.getString("SoDT"));
                hv.setQrCode(rs.getString("QrCode"));
                list.add(hv);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println("HoiVienDAO :" + e.getMessage());
        }
        return list;
    }

    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = GJDBC.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getHoiVien(Object... args) {
        String sql = SELECT_ALL_SQL;
        String[] cols = {"ID", "HoTen", "SoDT", "DiaChi", "MaNV"};
        return getListOfArray(sql, cols, args);
    }

    public List<Object[]> getHoiVienByID(Object... args) {
        String sql = "select KhachHang.HoTen, KhachHang.SoDT, KhachHang.GioiTinh, KhachHang.DiaChi, HoiVien.MaNV, Hinh "
                + " FROM HoiVien join KhachHang on HoiVien.SoDT = KhachHang.SoDT WHERE HoiVien.ID = ?";
        String[] cols = {"HoTen", "SoDT", "GioiTinh", "DiaChi", "MaNV", "Hinh"};
        return getListOfArray(sql, cols, args);
    }

    public List<Object[]> TimKiemHoiVien(Object... args) {
        String sql = "SELECT HoiVien.ID, KhachHang.HoTen, KhachHang.SoDT, KhachHang.DiaChi, HoiVien.MaNV"
                + " FROM HoiVien join KhachHang on HoiVien.SoDT = KhachHang.SoDT WHERE HoiVien.ID like ? or HoiVien.SoDT like ? or KhachHang.HoTen like ?";
        String[] cols = {"ID", "HoTen", "SoDT", "DiaChi", "MaNV"};
        return getListOfArray(sql, cols, args);
    }
}
