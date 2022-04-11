/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.entity;

/**
 *
 * @author lenovo
 */
public class GoiTap {
    private String MaGT, TenGoiTap, MaLoai;
    private Float Gia;
    private int ThoiLuong;

    public GoiTap() {
    }

    public GoiTap(String MaGT, String TenGoiTap, String MaLoai, Float Gia, int ThoiLuong) {
        this.MaGT = MaGT;
        this.TenGoiTap = TenGoiTap;
        this.MaLoai = MaLoai;
        this.Gia = Gia;
        this.ThoiLuong = ThoiLuong;
    }

    public String getMaGT() {
        return MaGT;
    }

    public void setMaGT(String MaGT) {
        this.MaGT = MaGT;
    }

    public String getTenGoiTap() {
        return TenGoiTap;
    }

    public void setTenGoiTap(String TenGoiTap) {
        this.TenGoiTap = TenGoiTap;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public Float getGia() {
        return Gia;
    }

    public void setGia(Float Gia) {
        this.Gia = Gia;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(int ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }
    
}
