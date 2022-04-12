/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.SanPham;
import com.group2.entity.SanPhamMua;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class SanPhamDAO extends GymSysDAO<SanPham, Object> {

    final String INSERT_SQL = "INSERT INTO SanPham (MaSP, TenSP, DonGia, SoLuong, NhaSanXuat, Hinh, GhiChu)  VALUES  (?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE  SanPham  SET TenSP =?,  DonGia=?,  SoLuong=? , NhaSanXuat=?, MaLoai =?, Hinh=?, GhiChu=? WHERE  MaSP=?";
    final String DELETE_SQL = "DELETE FROM SanPham WHERE MaSP=?";
    final String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    final String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSP=?";

    @Override
    public void insert(SanPham entity) {
        GJDBC.update(INSERT_SQL, entity.getMaSP(), entity.getTenSP(), entity.getDonGia(), entity.getSoLuong(),
                entity.getNhaSanXuat(), entity.getHinh(), entity.getGhiChu());
    }

    @Override
    public void update(SanPham entity) {
        GJDBC.update(UPDATE_SQL,entity.getTenSP(), entity.getDonGia(), entity.getSoLuong(),
                entity.getNhaSanXuat(),entity.getMaLoai(), entity.getHinh(), entity.getGhiChu(), entity.getMaSP());
    }

    @Override
    public void delete(Object id) {
        GJDBC.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectById(Object id) {
        List<SanPham> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectBySql(String sqlString, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = GJDBC.query(sqlString, args);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP").trim());
                sp.setTenSP(rs.getString("TenSp"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setNhaSanXuat(rs.getString("NhaSanXuat"));
                sp.setHinh(rs.getString("Hinh"));
                sp.setMaLoai(rs.getString("MaLoai"));
                sp.setGhiChu(rs.getString("GhiChu"));
                list.add(sp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SanPhamMua getSanPhamMua(String maSP) {
        SanPham sp = selectById(maSP);
        if (sp==null) return null;
        return new SanPhamMua(sp.getHinh(),sp.getMaSP(), sp.getTenSP(), sp.getDonGia(), 1);
    }

    public List<SanPham> timSanPham(String... args) {
        String sql = "select * from SanPham where MaSP like ? or tenSP like ?";
        return selectBySql(sql, args);
    }

    public List<SanPham> getLoaiSP() {
        String sql = "select * from SanPham sp join LoaiSanPham lsp\n"
                + "on sp.MaLoai = lsp.MaLoaiSP";
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = GJDBC.query(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSp"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setNhaSanXuat(rs.getString("NhaSanXuat"));
                sp.setHinh(rs.getString("Hinh"));
                sp.setGhiChu(rs.getString("GhiChu"));
                sp.setTenLoai(rs.getString("TenLoai"));
                list.add(sp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SanPham> LocSanPhamKhongTheoLoai(String Ten, Integer Gia1, Integer Gia2) {
        String sql = "select * from SanPham sp join LoaiSanPham lsp\n"
                + "on sp.MaLoai = lsp.MaLoaiSP where TenSP like ? and DonGia < ? and DonGia > ?";
        return this.selectBySql(sql,"%"+Ten+"%",Gia1,Gia2);
    }
    public List<SanPham> LocSanPhamTheoLoai(String LoaiSP, String Ten, Integer Gia1, Integer Gia2) {
        String sql = "select * from SanPham sp join LoaiSanPham lsp\n"
                + "on sp.MaLoai = lsp.MaLoaiSP where TenLoai like ? \n"
                + "and TenSP like ? and DonGia < ? and DonGia > ?";
        return this.selectBySql(sql, LoaiSP,"%"+Ten+"%",Gia1,Gia2);
    }

//    public List <SanPham> timSanPham2(String...args){
//        String sql = "select * from SanPham where MaSP like ? or tenSP like ?";
//        return selectBySql(sql, args);
//    }
        private List<Object[]> getListOfArray(String Sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = GJDBC.query(Sql, args);
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
            e.getMessage();
        }
        return null;
    }
    public List<Object[]> selectLoai(String...arg){
        String sql = "select TenLoai from LoaiSanPham where MaLoaiSP = ?";
        String[] cols={"TenLoai"};
        return getListOfArray(sql,cols,arg);
    }
}
