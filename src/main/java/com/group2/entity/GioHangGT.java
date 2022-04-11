/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuHoang
 */
public class GioHangGT {

    public static List<GoiTap> listGT = new ArrayList<>();
    public static float giamGia = 0;

    public static void clearGT() {
        GioHangGT.listGT.clear();
        giamGia = 0;

    }

    public static boolean themGTVaoGH(GoiTap gt) {
        if (listGT.contains(gt)) {
            return false;
        } else {
            listGT.add(gt);
            return true;
        }

    }

    public static float tongTienGH() {
        float tong = 0;
        for (GoiTap goiTap : listGT) {
            tong += goiTap.getGia();
        }
        return tong;
    }

    public static float tienThanhToan() {
        return tongTienGH() - tongTienGH() * giamGia;
    }
}
