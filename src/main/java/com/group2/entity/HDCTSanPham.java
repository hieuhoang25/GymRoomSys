/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.entity;

/**
 *
 * @author lenovo
 */
public class HDCTSanPham {
    private int MaHD, SoLuong;
    private String MaSP;
    private Float TongTien;

    public HDCTSanPham() {
    }

    public HDCTSanPham(int MaHD, int SoLuong, String MaSP, Float TongTien) {
        this.MaHD = MaHD;
        this.SoLuong = SoLuong;
        this.MaSP = MaSP;
        this.TongTien = TongTien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Float getTongTien() {
        return TongTien;
    }

    public void setTongTien(Float TongTien) {
        this.TongTien = TongTien;
    }
    
}
