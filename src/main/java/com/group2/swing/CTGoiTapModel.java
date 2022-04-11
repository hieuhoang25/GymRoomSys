/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.swing;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HieuHoang
 */
public class CTGoiTapModel {
    private String maGT;
    private String loaiGT;
    private Date ngayDK;
    private Date ngayHH;
    private String TenGoiTap;

        
    
    public CTGoiTapModel() {
    }

    public CTGoiTapModel(String maGT, String loaiGT, Date ngayDK, Date ngayHH, String TenGoiTap)  {
        this.maGT = maGT;
        this.loaiGT = loaiGT;
        this.ngayDK = ngayDK;
        this.ngayHH = ngayHH;
        this.TenGoiTap = TenGoiTap;
    }

    public String getMaGT() {
        return maGT;
    }

    public void setMaGT(String maGT) {
        this.maGT = maGT;
    }

    public String getLoaiGT() {
        return loaiGT;
    }

    public void setLoaiGT(String loaiGT) {
        this.loaiGT = loaiGT;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public Date getNgayHH() {
        return ngayHH;
    }

    public void setNgayHH(Date ngayHH) {
        this.ngayHH = ngayHH;
    }

    public String getTenGoiTap() {
        return TenGoiTap;
    }

    public void setTenGoiTap(String TenGoiTap) {
        this.TenGoiTap = TenGoiTap;
    }
    
}
