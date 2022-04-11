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
public class ChekIn {
    private int MaCheckIn, ID;

   
    private Date NgayChekIn;
    private String hoTen,soDT;

    public ChekIn() {
    }

    public ChekIn(int MaCheckIn, int ID, Date NgayChekIn) {
        this.MaCheckIn = MaCheckIn;
        this.ID = ID;
        this.NgayChekIn = NgayChekIn;
    }
     public ChekIn(int MaCheckIn, int ID, Date NgayChekIn,String hoTen) {
        this.MaCheckIn = MaCheckIn;
        this.ID = ID;
        this.NgayChekIn = NgayChekIn;
        this.hoTen = hoTen;
    }
      public ChekIn(String hoTen,String soDT) {
        this.soDT = soDT;
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public int getMaCheckIn() {
        return MaCheckIn;
    }

    public void setMaCheckIn(int MaCheckIn) {
        this.MaCheckIn = MaCheckIn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getNgayChekIn() {
        return NgayChekIn;
    }

    public void setNgayChekIn(Date NgayChekIn) {
        this.NgayChekIn = NgayChekIn;
    }
    
     public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return  hoTen +" - "+ soDT  ;
    }
    
}
