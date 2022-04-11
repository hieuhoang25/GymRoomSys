/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.swing;

/**
 *
 * @author HieuHoang
 */
public class ProductHot {
    private String maSP;
    private String tenSP;
    private int soLuongBanRa;

    public ProductHot() {
    }

    public ProductHot(String maSP, String tenSP, int soLuongBanRa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongBanRa = soLuongBanRa;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuongBanRa() {
        return soLuongBanRa;
    }

    public void setSoLuongBanRa(int soLuongBanRa) {
        this.soLuongBanRa = soLuongBanRa;
    }
    
}
