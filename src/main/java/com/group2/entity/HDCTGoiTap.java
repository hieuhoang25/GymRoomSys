/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.entity;

/**
 *
 * @author lenovo
 */
public class HDCTGoiTap {
    private int MaHD;
    private String MaGT;
    private Float ThanhTien;

    public HDCTGoiTap() {
    }

    public HDCTGoiTap(int MaHD, String MaGT, Float ThanhTien) {
        this.MaHD = MaHD;
        this.MaGT = MaGT;
        this.ThanhTien = ThanhTien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaGT() {
        return MaGT;
    }

    public void setMaGT(String MaGT) {
        this.MaGT = MaGT;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
