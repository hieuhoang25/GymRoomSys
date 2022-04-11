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
public class MenuItemModel {
    private String icon;
    private String title;
    private MenuItemType type;

    public MenuItemModel(String icon, String title, MenuItemType type) {
        this.icon = icon;
        this.title = title;
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MenuItemType getType() {
        return type;
    }

    public void setType(MenuItemType type) {
        this.type = type;
    }
    
    public MenuItemModel() {
    }
    
    
    public enum MenuItemType{
        MENUITEM, EMPTY;
    }
}
