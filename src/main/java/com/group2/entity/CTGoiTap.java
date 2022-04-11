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
public class CTGoiTap {
    private int ID;
    private String MaGT;
    private Date NgayDangKi, NgayHetHan;

    public CTGoiTap() {
    }

    public CTGoiTap(int ID, String MaGT, Date NgayDangKi, Date NgayHetHan) {
        this.ID = ID;
        this.MaGT = MaGT;
        this.NgayDangKi = NgayDangKi;
        this.NgayHetHan = NgayHetHan;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaGT() {
        return MaGT;
    }

    public void setMaGT(String MaGT) {
        this.MaGT = MaGT;
    }

    public Date getNgayDangKi() {
        return NgayDangKi;
    }

    public void setNgayDangKi(Date NgayDangKi) {
        this.NgayDangKi = NgayDangKi;
    }

    public Date getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(Date NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }
    
}
