/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.entity;

/**
 *
 * @author lenovo
 */
public class HoiVien {
    private int ID;
    private String MaNV, SoDT, qrCode;

    public HoiVien() {
    }

    public HoiVien(int ID, String MaNV, String SoDT, String qrCode) {
        this.ID = ID;
        this.MaNV = MaNV;
        this.SoDT = SoDT;
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public HoiVien(int ID, String MaNV, String SoDT) {
        this.ID = ID;
        this.MaNV = MaNV;
        this.SoDT = SoDT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }
    
}
