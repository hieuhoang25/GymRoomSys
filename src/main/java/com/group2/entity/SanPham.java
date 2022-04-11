
package com.group2.entity;

/**
 *
 * @author lenovo
 */
public class SanPham {
    private String MaSP, TenSP, NhaSanXuat, Hinh, GhiChu, MaLoai;
    private Float DonGia;
    private int SoLuong;
    private String tenLoai;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String NhaSanXuat, String Hinh, String GhiChu, String MaLoai, Float DonGia, int SoLuong, String tenLoai) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.NhaSanXuat = NhaSanXuat;
        this.Hinh = Hinh;
        this.GhiChu = GhiChu;
        this.MaLoai = MaLoai;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.tenLoai = tenLoai;
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

    public String getNhaSanXuat() {
        return NhaSanXuat;
    }

    public void setNhaSanXuat(String NhaSanXuat) {
        this.NhaSanXuat = NhaSanXuat;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
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

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }


    
    
}

