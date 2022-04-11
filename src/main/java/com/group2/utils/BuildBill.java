/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.utils;

import com.group2.entity.GioHangGT;
import com.group2.entity.GioHangSP;
import com.group2.entity.GoiTap;
import com.group2.entity.SanPhamMua;
import com.group2.swing.Alert;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author HieuHoang
 */
public class BuildBill {

    private static final String File_Name_Parent = "bill/";

    public static void createBillSP(String fileName, String sdt, String hoten, String diachi, String ghichu, String phuongthuc) {
        Document document = new Document();
        try {
            File file = new File(File_Name_Parent + fileName + ".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Font f = new Font();

            f.setStyle(Font.ITALIC);
            f.setSize(18);
            document.add(new Paragraph("Gym & Fitness", f));

            Paragraph p = new Paragraph();
            p.add("Dia chi: Phan men quang trung, Quan 12, TP.Ho Chi Minh");
            p.setAlignment(Element.ALIGN_LEFT);
            document.add(p);

            Font f2 = new Font();

            f2.setStyle(Font.BOLD);
            f2.setSize(19);
            Paragraph pTitle = new Paragraph("HOA DON SAN PHAM", f2);
            pTitle.setSpacingBefore(20);
            pTitle.setSpacingAfter(20);
            pTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pTitle);
            Paragraph pSDT = new Paragraph("SDT: " + sdt);
            document.add(pSDT);

            Paragraph typeHT = new Paragraph(removeAccent("Họ và tên: " + hoten));
            document.add(typeHT);

            Paragraph timeMua = new Paragraph("Thoi gian mua hang: " + new Date().toString());
            document.add(timeMua);

            Paragraph pDiaChi = new Paragraph(removeAccent("Dia chỉ: " + diachi));
            document.add(pDiaChi);

            PdfPTable t = new PdfPTable(5);

            t.setSpacingBefore(25);
            t.setSpacingAfter(0);
            f2.setSize(11);
            PdfPCell c1 = new PdfPCell(new Phrase("STT", f2));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Ten san pham", f2));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Don gia", f2));
            t.addCell(c3);

            PdfPCell c4 = new PdfPCell(new Phrase("So luong mua", f2));
            t.addCell(c4);

            PdfPCell c5 = new PdfPCell(new Phrase("Thanh tien", f2));
            t.addCell(c5);

            addSPMuaToTable(t);

            document.add(t);

            Paragraph pTT = new Paragraph(removeAccent("TT: " + df.format(GioHangSP.tongTienGH()) + "VND               "));
            pTT.setAlignment(Element.ALIGN_RIGHT);
            document.add(pTT);

            Paragraph pGiamGia = new Paragraph(removeAccent("Giảm giá: " + (GioHangSP.giamGia * 100) + "%               "));
            pGiamGia.setAlignment(Element.ALIGN_RIGHT);
            document.add(pGiamGia);

            Paragraph pThanhToan = new Paragraph(removeAccent("Thanh toán: " + df.format(GioHangSP.tienThanhToan()) + "VND               "));
            pThanhToan.setAlignment(Element.ALIGN_RIGHT);
            document.add(pThanhToan);

            Font f3 = new Font();

            f3.setStyle(Font.ITALIC);
            f3.setSize(10);
            Paragraph pGhiChu = new Paragraph(removeAccent("Ghi chú: " + ghichu), f3);
            pGhiChu.setAlignment(Element.ALIGN_LEFT);
            document.add(pGhiChu);

            Paragraph pPT = new Paragraph(removeAccent("Phương thức thanh toán: " + phuongthuc), f3);
            pPT.setAlignment(Element.ALIGN_LEFT);
            document.add(pPT);

            f3.setSize(12);
            Paragraph pCamOn = new Paragraph(removeAccent("Cám ơn quý khách"), f3);
            pCamOn.setSpacingBefore(20);

            pCamOn.setAlignment(Element.ALIGN_CENTER);
            document.add(pCamOn);

            Paragraph pHen = new Paragraph(removeAccent("Hẹn gặp lại"), f3);
            pHen.setAlignment(Element.ALIGN_CENTER);

            document.add(pHen);
            document.close();
            MsgBox.alert(null, "Thông báo", "Xuất hóa đơn thành công!", Alert.AlertType.SUCCESS);
            Desktop.getDesktop().browse(file.toURI());
        } catch (Exception e) {
//            MsgBox.alert(null, "Thông báo", "Không thể xuất hóa đơn!", Alert.AlertType.ERROR);

            e.printStackTrace();
        }

    }

    public static void createBillGT(String fileName, String sdt, String hoten, String diachi, String ghichu, String phuongthuc) {
        Document document = new Document();
        try {
            File file = new File(File_Name_Parent + fileName + ".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Font f = new Font();

            f.setStyle(Font.ITALIC);
            f.setSize(18);
            document.add(new Paragraph("Gym & Fitness", f));

            Paragraph p = new Paragraph();
            p.add("Dia chi: Phan men quang trung, Quan 12, TP.Ho Chi Minh");
            p.setAlignment(Element.ALIGN_LEFT);
            document.add(p);

            Font f2 = new Font();

            f2.setStyle(Font.BOLD);
            f2.setSize(19);
            Paragraph pTitle = new Paragraph("HOA DON GoiTap", f2);
            pTitle.setSpacingBefore(20);
            pTitle.setSpacingAfter(20);
            pTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pTitle);
            Paragraph pSDT = new Paragraph("SDT: " + sdt);
            document.add(pSDT);

            Paragraph typeHT = new Paragraph(removeAccent("Họ và tên: " + hoten));
            document.add(typeHT);

            Paragraph timeMua = new Paragraph("Thoi gian mua hang: " + new Date().toString());
            document.add(timeMua);

            Paragraph pDiaChi = new Paragraph(removeAccent("Dia chỉ: " + diachi));
            document.add(pDiaChi);

            PdfPTable t = new PdfPTable(5);

            t.setSpacingBefore(25);
            t.setSpacingAfter(0);
            f2.setSize(11);
            PdfPCell c1 = new PdfPCell(new Phrase("STT", f2));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Ten goi tap", f2));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Thoi luong(ngay)", f2));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Don gia", f2));
            t.addCell(c4);

            addGTMuaToTable(t);

            document.add(t);

            Paragraph pTT = new Paragraph(removeAccent("TT: " + df.format(GioHangGT.tongTienGH()) + "VND               "));
            pTT.setAlignment(Element.ALIGN_RIGHT);
            document.add(pTT);

            Paragraph pGiamGia = new Paragraph(removeAccent("Giảm giá: " + (GioHangGT.giamGia * 100) + "%               "));
            pGiamGia.setAlignment(Element.ALIGN_RIGHT);
            document.add(pGiamGia);

            Paragraph pThanhToan = new Paragraph(removeAccent("Thanh toán: " + df.format(GioHangGT.tienThanhToan()) + "VND               "));
            pThanhToan.setAlignment(Element.ALIGN_RIGHT);
            document.add(pThanhToan);

            Font f3 = new Font();

            f3.setStyle(Font.ITALIC);
            f3.setSize(10);
            Paragraph pGhiChu = new Paragraph(removeAccent("Ghi chú: " + ghichu), f3);
            pGhiChu.setAlignment(Element.ALIGN_LEFT);
            document.add(pGhiChu);

            Paragraph pPT = new Paragraph(removeAccent("Phương thức thanh toán: " + phuongthuc), f3);
            pPT.setAlignment(Element.ALIGN_LEFT);
            document.add(pPT);

            f3.setSize(12);
            Paragraph pCamOn = new Paragraph(removeAccent("Cám ơn quý khách"), f3);
            pCamOn.setSpacingBefore(20);

            pCamOn.setAlignment(Element.ALIGN_CENTER);
            document.add(pCamOn);

            Paragraph pHen = new Paragraph(removeAccent("Hẹn gặp lại"), f3);
            pHen.setAlignment(Element.ALIGN_CENTER);

            document.add(pHen);
            document.close();
            MsgBox.alert(null, "Thông báo", "Xuất hóa đơn thành công!", Alert.AlertType.SUCCESS);
            Desktop.getDesktop().browse(file.toURI());
        } catch (Exception e) {
//            MsgBox.alert(null, "Thông báo", "Không thể xuất hóa đơn!", Alert.AlertType.ERROR);

            e.printStackTrace();
        }

    }

    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
    private static DecimalFormat df = new DecimalFormat("###,###.###");

    private static void addSPMuaToTable(PdfPTable t) {
        for (int i = 0; i < GioHangSP.listSP.size(); i++) {
            SanPhamMua s = GioHangSP.listSP.get(i);
            t.addCell(i + "");
            t.addCell(removeAccent(s.getTenSP()));
            t.addCell(df.format(s.getDonGia()) + "₫");
            t.addCell(s.getSoLuong() + "");
            t.addCell(df.format(s.getDonGia()) + "₫");
        }
    }

    private static void addGTMuaToTable(PdfPTable t) {
        for (int i = 0; i < GioHangGT.listGT.size(); i++) {
            GoiTap gt = GioHangGT.listGT.get(i);
            t.addCell(i + "");
            t.addCell(removeAccent(gt.getTenGoiTap()));
            t.addCell(gt.getThoiLuong()+"");
            t.addCell(df.format(gt.getGia()) + "₫");

        }
    }

}
