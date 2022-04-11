package com.group2.entity;

import java.util.Objects;

/**
 *
 * @author lenovo
 */
public class SanPhamMua {
    private String hinh;
    private String MaSP, TenSP;
    private Float DonGia;
    private int SoLuong;
    private Float ThanhTien;
    
    public SanPhamMua() {
        SoLuong = 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPhamMua other = (SanPhamMua) obj;
        if (!Objects.equals(this.MaSP, other.MaSP)) {
            return false;
        }
        return true;
    }

    public SanPhamMua(String MaSP, String TenSP, Float DonGia, int SoLuong) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public SanPhamMua(String hinh, String MaSP, String TenSP, Float DonGia, int SoLuong) {
        this.hinh = hinh;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Float getThanhTien() {
        return SoLuong*DonGia;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

}
