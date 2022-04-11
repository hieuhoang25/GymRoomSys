/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.utils;

import com.group2.entity.NhanVien;

/**
 *
 * @author lenovo
 */
public class Auth {
    public static NhanVien user = null;
    public static void clear(){
        Auth.user = null;
    }

    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin() && user.getChucVu().equalsIgnoreCase("Quản lý")==true;
    }
}
