/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.test;

/**
 *
 * @author HieuHoang
 */
public class Book {

    private Integer id;
    private String title;
    private Integer quantity;
    private Double price;
    private Double totalMoney;
    public Book(){
        
    }
    public Book(int id,
     String title,
     int quantity,
 double price,
     double totalMoney){
        this.id = id;
        this.title = title;
        this.quantity=quantity;
        this.price = price;
        this.totalMoney = totalMoney;
        
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the totalMoney
     */
    public Double getTotalMoney() {
        return totalMoney;
    }

    /**
     * @param totalMoney the totalMoney to set
     */
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
    
}
