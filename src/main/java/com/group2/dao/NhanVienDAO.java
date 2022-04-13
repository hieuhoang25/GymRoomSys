/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.NhanVien;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class NhanVienDAO extends GymSysDAO<NhanVien, String> {
    final String INSERT_SQL = "INSERT INTO  NhanVien (MaNV, MatKhau, HoTen, ChucVu, SoDT , Hinh, DiaChi, NgaySinh)  VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE  NhanVien  SET  MatKhau=?,  HoTen=?,  ChucVu=? , SoDT =? , Hinh=?, DiaChi=?, NgaySinh=? WHERE  MaNV=?";
    final String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";
    @Override
    public void insert(NhanVien entity) {
        GJDBC.update(INSERT_SQL, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.getChucVu(), 
                entity.getSoDT(),entity.getHinh(), entity.getDiaChi(),entity.getNgaySinh());
    }

    @Override
    public void update(NhanVien entity) {
        GJDBC.update(UPDATE_SQL, entity.getMatKhau(), entity.getHoTen(), entity.getChucVu(),entity.getSoDT(),entity.getHinh(), 
                entity.getDiaChi(), entity.getNgaySinh(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        GJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sqlString, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs =GJDBC.query(sqlString, args);
            while (rs.next()) {                
                NhanVien nv= new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setChucVu(rs.getString("ChucVu"));
                nv.setHinh(rs.getString("Hinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDT(rs.getString("SoDT"));
                nv.setNgaySinh( rs.getDate("NgaySinh"));
                list.add(nv);         
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return list;
    }
    
    public List<NhanVien> timNhanVien(String...args){
        String sql = "select * from nhanvien where MaNV like ? or HoTen like ?";
        return selectBySql(sql, args);
    }
    
}
