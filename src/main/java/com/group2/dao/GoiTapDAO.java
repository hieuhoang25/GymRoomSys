/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.GoiTap;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class GoiTapDAO extends GymSysDAO<GoiTap, Object> {

    final String INSERT_SQL = "INSERT INTO GoiTap (MaGT, TenGoiTap, Gia, ThoiLuong, MaLoai)  VALUES  (?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE  GoiTap  SET TenGoiTap=?, Gia=?, ThoiLuong=?,  MaLoai=? WHERE MaGT=?";
    final String DELETE_SQL = "DELETE FROM GoiTap WHERE MaGT=?";
    final String SELECT_ALL_SQL = "SELECT * FROM GoiTap";
    final String SELECT_BY_ID_SQL = "SELECT * FROM GoiTap WHERE MaGT=?";

    @Override
    public void insert(GoiTap entity) {
        GJDBC.update(INSERT_SQL, entity.getMaGT(), entity.getTenGoiTap(), entity.getGia(), entity.getThoiLuong(), entity.getMaLoai());
    }

    @Override
    public void update(GoiTap entity) {
         GJDBC.update(UPDATE_SQL, entity.getTenGoiTap(), entity.getGia(), entity.getThoiLuong(), entity.getMaLoai(), entity.getMaGT());
    }

    @Override
    public void delete(Object id) {
        GJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<GoiTap> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public GoiTap selectById(Object id) {
        List<GoiTap> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GoiTap> selectBySql(String sqlString, Object... args) {
        List<GoiTap> list = new ArrayList<>();
        try {
            ResultSet rs = GJDBC.query(sqlString, args);
            while (rs.next()) {
                GoiTap gt = new GoiTap();
                gt.setMaGT(rs.getString("MaGT"));
                gt.setTenGoiTap(rs.getString("TenGoiTap"));
                gt.setGia(rs.getFloat("Gia"));
                gt.setThoiLuong(rs.getInt("ThoiLuong"));
                gt.setMaLoai(rs.getString("MaLoai"));
                list.add(gt);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
