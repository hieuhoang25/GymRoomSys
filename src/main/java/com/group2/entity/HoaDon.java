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
public class HoaDon {
    private int MaHD;
    private String MaKH, MaNV, GhiChu, LoaiHoaDon;
    private Date ThoiGianMua;

    public HoaDon() {
    }
    public HoaDon(int MaHD, String MaKH, String MaNV, String GhiChu, String LoaiHoaDon, Date ThoiGianMua) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.GhiChu = GhiChu;
        this.LoaiHoaDon = LoaiHoaDon;
        this.ThoiGianMua = ThoiGianMua;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getLoaiHoaDon() {
        return LoaiHoaDon;
    }

    public void setLoaiHoaDon(String LoaiHoaDon) {
        this.LoaiHoaDon = LoaiHoaDon;
    }

    public Date getThoiGianMua() {
        return ThoiGianMua;
    }

    public void setThoiGianMua(Date ThoiGianMua) {
        this.ThoiGianMua = ThoiGianMua;
    }
    
}
