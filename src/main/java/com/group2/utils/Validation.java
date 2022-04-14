/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HieuHoang
 */
public class Validation {
//    kiểm tra chuỗi

    public static boolean checkLength(String str) {
        return str.length() == 0 ? false : true;
    }

    //kiểm tra biết thức chính quy
    // email: \\w+@\\w+(\\.\\w+){1,2}
    // sdt:^(84|0[3|5|7|8|9])[0-9]{8}$
    public static boolean checkExperession(String str, String regex) {
//       return str.matches(regex);
        //var regex = "^[a-z]+[\\w._]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    // Chuỗi hợp lệ
    public static boolean correctString(String str) {
        return str.length() >= 6 ? true : false;
    }

    //kiểm tra số
    public static boolean checkInt(String str) {
        try {
            int number = Integer.parseInt(str);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkDouble(String str) {
        try {
            double number = Double.parseDouble(str);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkToDate(String date, String regex) {
        try {
            GDate.toDate(date, regex);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkToString(Date date, String regex) {
        try {
            GDate.toString(date, regex);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    //kiem tra ten
     public boolean checkName(String str){
         return str.matches("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]+$");
    }
     //check email
       public boolean checkEmail(String str) {
        return str.matches("^[a-zA-Z]+\\w+@{1}[a-zA-Z]+\\.{1}(com){1}(.vn)?$");
    }
       public boolean checkDate(String str){
           return str.matches("((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])");
       }
}
