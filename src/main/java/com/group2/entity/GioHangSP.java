/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class GioHangSP {

    public static List<SanPhamMua> listSP = new ArrayList<>();
    public static float giamGia = 0;
    public static void clearSP() {
        GioHangSP.listSP.clear();
        giamGia = 0;
        
    }

    public static void spDaMua(SanPhamMua sp) {
        if (listSP.size() == 0) {
            listSP.add(sp);
        } else {
            if (listSP.contains(sp)) {
                for (SanPhamMua sanPhamMua : listSP) {
                    if (sanPhamMua.equals(sp)) {
                        sanPhamMua.setSoLuong(sanPhamMua.getSoLuong() + sp.getSoLuong());
                    }
                }
            } else {
                listSP.add(sp);
            }
        }
    }
    public static float tongTienGH(){
        float tong=0;
        for (SanPhamMua sanPhamMua : listSP) {
            tong+=sanPhamMua.getThanhTien();
        }
        return tong ;
    }
   public static float tienThanhToan(){
       return tongTienGH() - tongTienGH()*giamGia;
   }
}
