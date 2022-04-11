/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.entity;

/**
 *
 * @author LONG
 */
public class ThongKe {
    private String MaSP;
    private Integer soLuong;
    private String tenSP;
    private String hoTen;
    private String soDT;
    private String ngayHetHan;

    public ThongKe(String hoTen, String soDT, String ngayHetHan) {
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.ngayHetHan = ngayHetHan;
    }

    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public ThongKe(String MaSP, Integer soLuong, String tenSP) {
        this.MaSP = MaSP;
        this.soLuong = soLuong;
        this.tenSP = tenSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public ThongKe(String MaSP, Integer soLuong) {
        this.MaSP = MaSP;
        this.soLuong = soLuong;
    }

    public ThongKe() {
    }
    

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
    
}
