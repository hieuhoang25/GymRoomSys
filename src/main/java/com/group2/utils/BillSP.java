/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.utils;

import com.group2.entity.GioHangSP;
import com.group2.entity.SanPhamMua;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author HieuHoang
 */
public class BillSP {

    private static DecimalFormat df = new DecimalFormat("###,###.###");
    Double totalAmount = 0.0;
    Double cash = 0.0;
    Double balance = 0.0;
    Double bHeight = 0.0;
    String sdt;
    String manv;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a, dd/MM/yyyy");
    public void printBill(String sdt, String manv) {
        this.sdt = sdt;
        this.manv = manv;
        bHeight = Double.valueOf(GioHangSP.listSP.size());
        //JOptionPane.showMessageDialog(rootPane, bHeight);
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
        try {
            pj.print();

        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }

    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double bodyHeight = bHeight;
        double headerHeight = 5.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));

        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);

        return pf;
    }

    protected static double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    public class BillPrintable implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {

            ImageIcon icon = new ImageIcon(getClass().getResource("/com/group2/icons/logo2.PNG"));
            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                Graphics2D g2d = (Graphics2D) graphics;
                double width = pageFormat.getImageableWidth();
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
                try {
                    int y = 20;
                    int yShift = 10;
                    int headerRectHeight = 15;
//            int headerRectHeight=40;
                    JFrame frame = new JFrame();

                    g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                    g2d.drawImage(icon.getImage(), 100, 20, 30, 30, frame.getRootPane());
                    y += yShift + 30;
                    g2d.drawString("-------------------------------------", 12, y);
                    y += yShift;
                    g2d.drawString("         Gym For Heath          ", 12, y);
                    y += yShift;
                    g2d.drawString("Address:CVPM Quang Trung, Q.12, TP.HCM", 12, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 12, y);
                    y += yShift;
                    g2d.drawString("           HÓA ĐƠN SẢN PHẨM          ", 12, y);
                    y += yShift;
                    g2d.drawString("SĐT-KH:"+sdt, 12, y);
                    y += yShift;
                    g2d.drawString("Ngày bán:"+sdf.format(new Date()), 12, y);
                    y += yShift;
                    g2d.drawString("NVBH:"+manv, 12, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 12, y);
                    y += headerRectHeight;

                    g2d.drawString(" Tên sản phẩm               Thành tiền   ", 10, y);
                    y += yShift;
                    g2d.drawString("--------------------------------------", 10, y);
                    y += headerRectHeight;

                    for (SanPhamMua sanPhamMua : GioHangSP.listSP) {
                        g2d.drawString(" " + sanPhamMua.getTenSP() + "                            ", 10, y);
                        y += yShift;
                        g2d.drawString(" SL:" + sanPhamMua.getSoLuong() + " * Đơn giá: " + df.format(sanPhamMua.getDonGia()), 10, y);
                        g2d.drawString(df.format(sanPhamMua.getThanhTien()), 160, y);
                        y += yShift;
                    }

                    g2d.drawString("-------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString(" Tổng tiền:                " + df.format(GioHangSP.tongTienGH()) + "   ", 10, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString(" Giảm giá:                  " + GioHangSP.giamGia*100 + "%   ", 10, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 10, y);
                    y += yShift;
                    g2d.drawString(" Thanh toán:              " + df.format(GioHangSP.tienThanhToan()) + "   ", 10, y);
                    y += yShift;

                    g2d.drawString("*************************************", 10, y);
                    y += yShift;
                    g2d.drawString("       THANK YOU, COME AGAIN            ", 10, y);
                    y += yShift;
                    g2d.drawString("*************************************", 10, y);
                    y += yShift;
                    g2d.drawString("       SOFTWARE BY:FPT Poly          ", 10, y);
                    y += yShift;
                    g2d.drawString("   CONTACT: gymforheath@gmail.com       ", 10, y);
                    y += yShift;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }
    }
}
