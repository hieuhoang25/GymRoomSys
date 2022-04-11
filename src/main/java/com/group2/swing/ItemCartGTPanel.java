/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.swing;

import com.group2.entity.GioHangGT;
import com.group2.entity.GoiTap;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HieuHoang
 */
public class ItemCartGTPanel extends javax.swing.JPanel {

    DecimalFormat df = new DecimalFormat("###,###.###");
    private GoiTap gt;
    private JPanel listItemGT;
    private JLabel lblThanhTien, lblTongTien;
    private GioHangGTPanel gioHangGTPanel;

    /**
     * Creates new form ItemCartGTPanel
     */
    public ItemCartGTPanel(GoiTap gt, JPanel listItemGT, GioHangGTPanel gioHangGTPane, JLabel lblThanhTien, JLabel lblTongTien) {
        this.gioHangGTPanel = gioHangGTPane;

        this.gt = gt;
        this.listItemGT = listItemGT;
        this.lblThanhTien = lblThanhTien;
        this.lblTongTien = lblTongTien;
        initComponents();
        imageView1.setImage(new ImageIcon(getClass().getResource("/com/group2/icons/" + gt.getMaLoai().trim() + ".png")));
        lblTen.setText(gt.getTenGoiTap());
        lblThoiLuong.setText(gt.getThoiLuong() + "ngày");
        lblDonGia.setText(df.format(gt.getGia()) + "₫");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageView1 = new com.group2.swing.ImageView();
        lblTen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblThoiLuong = new javax.swing.JLabel();
        lblDonGia = new javax.swing.JLabel();
        buttonIcon1 = new com.group2.swing.ButtonIcon();

        setBackground(new java.awt.Color(255, 255, 255));

        imageView1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/group2/icons/gym.png"))); // NOI18N

        lblTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTen.setText("Gói tập gym theo tháng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(150, 150, 150));
        jLabel2.setText("Thời lượng:");

        lblThoiLuong.setFont(new java.awt.Font("Tahoma", 2, 15)); // NOI18N
        lblThoiLuong.setText("365 ngày");

        lblDonGia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDonGia.setForeground(new java.awt.Color(204, 0, 51));
        lblDonGia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonGia.setText("1.600.000 đ");

        buttonIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group2/icons/delete.png"))); // NOI18N
        buttonIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIcon1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblThoiLuong)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIcon1ActionPerformed
        // TODO add your handling code here:
        GioHangGT.listGT.remove(gt);
        listItemGT.remove(this);
        listItemGT.repaint();
        gioHangGTPanel.setSLGoiTap();
        lblThanhTien.setText(df.format(GioHangGT.tongTienGH()) + "₫");
        lblTongTien.setText(df.format(GioHangGT.tienThanhToan()) + "₫");
    }//GEN-LAST:event_buttonIcon1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.ButtonIcon buttonIcon1;
    private com.group2.swing.ImageView imageView1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThoiLuong;
    // End of variables declaration//GEN-END:variables
}
