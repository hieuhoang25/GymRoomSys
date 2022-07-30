/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.ChekIn;
import com.group2.entity.HoiVien;
import com.group2.utils.GJDBC;
import com.group2.utils.GDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LONG
 */
public class CheckInDAO {

    String INSERT_SQL = "INSERT INTO CheckIn(ID,NgayCheckIn)  VALUES (?,?)";
    String SELECT_ALL_SQL = "SELECT * FROM CheckIn";

    protected List<ChekIn> selectBySql(String sql, Object... args) {
        List<ChekIn> list = new ArrayList<ChekIn>();
        try {
            ResultSet rs = GJDBC.query(sql, args);
            while (rs.next()) {
                ChekIn chk = new ChekIn();
                chk.setID(rs.getInt("ID"));
                chk.setMaCheckIn(rs.getInt("MaChkIn"));
                chk.setNgayChekIn(rs.getDate("NgayCheckIn"));
                list.add(chk);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println("CheckInDAO: " + e.getMessage());
        }
        return list;
    }

    public void insert(Integer ID) {
        GJDBC.update(INSERT_SQL, ID, GDate.toDate(java.time.LocalDate.now().toString(), "yyyy-MM-dd"));
    }

    public List<ChekIn> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<ChekIn> SoHVCheckIn() {
        String sql = "{CALL sp_ThongKeNguoiCheckIn}";
        List<ChekIn> list = new ArrayList<ChekIn>();
        try {
            ResultSet rs = GJDBC.query(sql);
            while (rs.next()) {
                ChekIn chk = new ChekIn();
                chk.setHoTen(rs.getString("HoTen"));
                chk.setSoDT(rs.getString("SoDT"));
                list.add(chk);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println("CheckInDAO-SoHVCheckIn(): " + e.getMessage());
        }
        return list; 
    }

    public void deleteCheckIn(Date date) {
        String sql = "{CALL tableCheckIn (?)}";
        try {
            ResultSet rs = GJDBC.query(sql, date);
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("CheckInDAO-deletecheckin " + e.getMessage());
        }
    }

    public boolean check(String soDt) {
        String sql = "select count(*) as 't' from CheckIn chk join HoiVien hv on chk.ID\n"
                + "= hv.ID where SoDT = ?";
        boolean n = true;
        Integer a = 0;
        try {
            ResultSet rs = GJDBC.query(sql, soDt);
            while (rs.next()) {
                a = rs.getInt("t");
            }
            rs.getStatement().getConnection().close();
            if (a > 0) {
                n = false;
            }
        } catch (Exception e) {
            System.out.println("check-CheckInDao: " + e.getMessage());
        }
        return n;
    }

}
