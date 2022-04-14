/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import com.group2.entity.ThongKe;
import com.group2.utils.GJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LONG
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String Sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = GJDBC.query(Sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println("ThongKeDAO: " + e.getMessage());
        }
        return null;
    }

    public List<Object[]> getHVCheckIn() {
        String sql = "{CALL sp_ThongKeNguoiCheckIn}";
        String[] cols = {"HoTen, SoDT"};
        return this.getListOfArray(sql, cols);
    }

    public List<ThongKe> AVGSP() {
        List<ThongKe> list = new ArrayList<>();
        String sql = "select TOP 5  hdct.MaSP,SUM( hdct.SoLuong) as 'SoLuong',TenSP from HDCTSanPham hdct join Hoadon hd \n"
                + "on hd.MaHD = hdct.MaHD join SanPham sp on sp.MaSP = hdct.MaSP\n"
                + "where MONTH(ThoiGianMua) = MONTH(CURRENT_TIMESTAMP)\n"
                + "group by  hdct.MaSP,TenSP order by SUM( hdct.SoLuong) desc";
        try {
            ResultSet rs = GJDBC.query(sql);
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaSP(rs.getString("MaSP").trim());
                tk.setSoLuong(rs.getInt("SoLuong"));
                tk.setTenSP(rs.getString("TenSP"));
                list.add(tk);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println("check-CheckInDao: " + e.getMessage());
        }
        return list;
    }

    public List<ThongKe> HVSapHetHan() {
        List<ThongKe> list = new ArrayList<>();
        String sql = "select HoTen,kh.SoDT,NgayHetHan from CTGoiTap ct join HoiVien hv\n"
                + "on ct.ID = hv.ID join KhachHang kh on kh.SoDT = hv.SoDT\n"
                + "where DATEDIFF(DAY,CAST(GETDATE() as date),NgayHetHan) <= 5"
                + "and DATEDIFF(DAY,CAST(GETDATE() as date),NgayHetHan) >= 1";
        try {
            ResultSet rs = GJDBC.query(sql);
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setHoTen(rs.getString("HoTen"));
                tk.setSoDT(rs.getString("SoDT"));
                tk.setNgayHetHan(rs.getString("NgayHetHan"));
                list.add(tk);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println("HVSapHetHan-CheckInDao: " + e.getMessage());
        }
        return list;
    }

    public Double thongKeGoiTapTheoThang(int Thang, int Nam) {
        String sql = "select TongTien from (select sum(ThanhTien) as TongTien,MONTH(ThoiGianMua) as Thang from HDCTGoiTap hdct join Hoadon hd on hdct.MaHD = hd.MaHD where year(hd.ThoiGianMua) = ? group by MONTH(ThoiGianMua))as tb WHERE  tb.Thang = ?";
        Double n = 0.0;
        try {
            ResultSet rs = GJDBC.query(sql,Nam ,Thang);
            while (rs.next()) {
                n = rs.getDouble("TongTien");
                return n;
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("HVSapHetHan-CheckInDao: " + e.getMessage());
        }

        return 0.0;
    }

    public Double thongKeSanPhamTheoThang(int Thang, int Nam) {
        String sql = "select TongTien from (select sum(TongTien) as TongTien,MONTH(ThoiGianMua) as Thang from HDCTSanPham hdct join Hoadon hd on hdct.MaHD = hd.MaHD where year(hd.ThoiGianMua) = ?  group by MONTH(ThoiGianMua))as tb WHERE  tb.Thang = ?";
        Double n = 0.0;
        try {
            ResultSet rs = GJDBC.query(sql, Nam,Thang);
            while (rs.next()) {
                n = rs.getDouble("TongTien");
                return n;
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("thongKeSanPhamTheoThang-TKDao: " + e.getMessage());
        }

        return n;
    }

    public Integer thongKeKhachHang() {
        String sql = "select COUNT(*) as 'SLKH' from KhachHang where SoDT not in (select SoDT from HoiVien);";
        Integer n = 0;
        try {
            ResultSet rs = GJDBC.query(sql);
            while (rs.next()) {
                n = rs.getInt("SLKH");
                return n;
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("thongKeKhachHang-TKDAO: " + e.getMessage());
        }

        return n;
    }

    public Integer thongKeHoiVien() {
        String sql = "select count(*) as 'SLHV' from HoiVien";
        Integer n = 0;
        try {
            ResultSet rs = GJDBC.query(sql);
            while (rs.next()) {
                n = rs.getInt("SLHV");
                return n;
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("thongKeHoiVien-TKDAO " + e.getMessage());
        }

        return n;
    }

    public Integer thongKeGoiTap(String loaiGT) {
        String sql = "select COUNT(ct.MaGT) as 'SL' from CTGoiTap ct join GoiTap gt\n"
                + "on ct.MaGT = gt.MaGT where ct.MaGT LIKE ? group by ct.MaGT";
        Integer n = 0;
        try {
            ResultSet rs = GJDBC.query(sql, "%" + loaiGT + "%");
            while (rs.next()) {
                n = rs.getInt("SL");
                return n;
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println("thongKeGoiTap-TKDAO " + e.getMessage());
        }
        return n;
    }

    public List<Object[]> BuyHistory(String MaKH) {
        String sql = "select iif( hd.MaHD  in (select ct.MaHD from HDCTSanPham as ct),'HDSP','HDGT') as LoaiHoaDon,  hd.ThoiGianMua from HoaDon as hd \n"
                + " where HD.MaKH = ?";
        String[] cols = {"LoaiHoaDon", "ThoiGianMua"};
        return this.getListOfArray(sql, cols, MaKH);
    }

    public List<Integer> getYears() {
        String sql = "select DISTINCT year(ThoiGianMua) from HoaDon";
        List<Integer> list = new ArrayList<>();
        ResultSet rs = GJDBC.query(sql);
        try {
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
