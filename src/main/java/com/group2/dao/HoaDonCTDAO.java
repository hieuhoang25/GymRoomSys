/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author LONG
 */
public class HoaDonCTDAO {

    public void themHoaDonGoiTap(String soDT, String maNV, String ghiChu, String hoTen, String diaChi, 
            Date ngaySinh, Integer gioiTinh, String hinh, String email) {
        String sql = "{CALL pr_hoaDonGoiTap (?,?,?,?,?,?,?,?,?)}"; 
        try {
            ResultSet rs = GJDBC.query(sql, soDT, maNV, ghiChu, hoTen, diaChi, ngaySinh, gioiTinh, hinh, email);
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("HoaDonCTDAO-themHoaDonGoiTap: " + e.getMessage());
        }
    }
    
    public void themHDCTGoiTap(String maGT,String maKH,float thanhTien){
        String sql = "{CALL pr_HDCTGoiTap (?,?,?)}";
        try {
             ResultSet rs = GJDBC.query(sql,maGT,maKH,thanhTien);
             rs.getStatement().getConnection().close();
        } catch (Exception e) {
             System.out.println("HoaDonCTDAO-themHDCTGoiTap: " + e.getMessage());
        }
    }

    public float tongChiTieuKH(String sdt) {
        String sql = "{CALL pr_tongTienChiTieuKhachHang (?) }";
        float n = (float) 0.0;
        try {
            ResultSet rs = GJDBC.query(sql, sdt);
            while (rs.next()) {
                n = rs.getFloat("TongTien");
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("HoaDonCTDAO-tongChiTieuKH: " + e.getMessage());
        }
        return n;
    }

    public void themHoaDonSanPham(String maKH, String maNV, String ghiChu, String maSP,
            Integer soLg, Float tongTien, String hoTen, String diaChi, Date ngaySinh, Integer gioiTinh,
            String hinh, String email) {
        String sql = "{CALL pr_hoaDonSP (?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ResultSet rs = GJDBC.query(sql, maKH, maNV, ghiChu, maSP, soLg, tongTien,
                    hoTen, diaChi, ngaySinh, gioiTinh, hinh, email);
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("HoaDonCTDAO-themHoaDonSanPham: " + e.getMessage());
        }
    }

    public void themKHVaHD(String maKH, String maNV, String ghiChu, String hoTen, String diaChi, Date ngaySinh, Integer gioiTinh,
            String hinh, String email) {
        String sql = "{CALL proc_themKHvaHD (?,?,?,?,?,?,?,?,?)}";
        try {
            ResultSet rs = GJDBC.query(sql, maKH, maNV, ghiChu,
                    hoTen, diaChi, ngaySinh, gioiTinh, hinh, email);
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("HoaDonCTDAO-themHoaDonSanPham: " + e.getMessage());
        }
    }

    public void themSPVaoHD(String maSP,
            Integer soLg, Float tongTien) {
        String sql = "{CALL proc_themSPVaoHD (?,?,?)}";
        try {
            ResultSet rs = GJDBC.query(sql,  maSP, soLg, tongTien);
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("HoaDonCTDAO-themHoaDonSanPham: " + e.getMessage());
        }
    }
}
