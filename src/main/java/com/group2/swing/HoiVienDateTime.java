/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.swing;

import java.util.Date;

/**
 *
 * @author HieuHoang
 */
public class HoiVienDateTime {
    private String ten;
    private String soDT;
    private Date ngayHH;

    public HoiVienDateTime() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public Date getNgayHH() {
        return ngayHH;
    }

    public void setNgayHH(Date ngayHH) {
        this.ngayHH = ngayHH;
    }

    public HoiVienDateTime(String ten, String soDT, Date ngayHH) {
        this.ten = ten;
        this.soDT = soDT;
        this.ngayHH = ngayHH;
    }
    
}
