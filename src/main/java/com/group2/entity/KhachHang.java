/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.entity;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class KhachHang {

    private String SoDT, HoTen, DiaChi, Hinh;
    private Date NgaySinh;
    private boolean GioiTinh;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String email;

    public KhachHang() {
    }

    public KhachHang(String SoDT, String HoTen, String DiaChi, String Hinh, Date NgaySinh, boolean GioiTinh) {
        this.SoDT = SoDT;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.Hinh = Hinh;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

}
