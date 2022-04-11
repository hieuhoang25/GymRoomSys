/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.utils;

import com.group2.swing.Alert;
import com.group2.swing.Confirm;
import com.group2.swing.InputJDailog;
import java.awt.Component;
import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author HieuHoang
 */
public class MsgBox {
    public static void alert(Window  parent, String title, String msg, Alert.AlertType type){
        new Alert(parent, title, msg, type);
    }
    public static boolean confirm(Window parent, String msg){
        Confirm c = new Confirm(parent, msg);
        return c.getAnswer()==0 ? true : false;
    }
    public static String input(Window paWindow, String title, String msg){
        InputJDailog inputJDailog = new InputJDailog(paWindow, title ,msg);
        return inputJDailog.getInput();
    }
}
