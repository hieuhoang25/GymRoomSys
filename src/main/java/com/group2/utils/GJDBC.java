/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GJDBC {
    private static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=GymSysTem";
    private static String user = "sa";
    private static String pass = "123";
    
    static{
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException{
        Connection connection = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if(sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);
        }else{
            pstmt = connection.prepareStatement(sql);
        }
        for(int i = 0; i < args.length; i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    
    public static int update(String sql, Object...args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            }finally{
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet query(String sql, Object...args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
           
            return stmt.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Object value(String sql, Object...args){
        try {
            ResultSet rs = query(sql, args);
            if(rs.next()){
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }
 
}
