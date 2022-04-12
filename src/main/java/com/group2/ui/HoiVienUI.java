/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.HoiVienDAO;
import com.group2.swing.AvataTbHoiVien;
import com.group2.swing.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;
//<<<<<<< HEAD
//import com.group2.entity.HoiVien;
//=======
import com.group2.swing.AvataTbHoiVien;
import com.group2.swing.AvataTbNhanVien;

import com.group2.entity.HoiVien;

import com.group2.swing.ScrollBarCustom;
import com.group2.swing.TimeDatePanel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author HieuHoang
 */
public class HoiVienUI extends javax.swing.JPanel {

    HoiVienDAO hvDAO = new HoiVienDAO();
    DefaultTableModel model;

    /**
     * Creates new form HoiVienUI
     */
    public HoiVienUI() {
        initComponents();
        designTable();
        fillToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientBackGround1 = new com.group2.swing.GradientBackGround();
        txtTimKiem = new com.group2.swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoiVien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setOpaque(false);

        gradientBackGround1.setBorderRadius(5);
        gradientBackGround1.setShadowSize(5);

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiem.setLabelText("Nhập ID hoặc Số điện thoại");
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        tblHoiVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHoiVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Số điện thoại", "Địa chỉ", "Mã nhân viên tạo", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoiVien.setRowHeight(25);
        tblHoiVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoiVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoiVien);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Còn hạn");

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Hết hạn");

        javax.swing.GroupLayout gradientBackGround1Layout = new javax.swing.GroupLayout(gradientBackGround1);
        gradientBackGround1.setLayout(gradientBackGround1Layout);
        gradientBackGround1Layout.setHorizontalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gradientBackGround1Layout.setVerticalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoiVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoiVienMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            new ChiTietHoiVienJDailog((int) tblHoiVien.getValueAt(tblHoiVien.getSelectedRow(), 0)).setVisible(true);
        }
    }//GEN-LAST:event_tblHoiVienMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        timKiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.GradientBackGround gradientBackGround1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoiVien;
    private com.group2.swing.TextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void designTable() {
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setHorizontalScrollBar(new ScrollBarCustom());
        tblHoiVien.getTableHeader().setBackground(new Color(0, 51, 204));
        tblHoiVien.getTableHeader().setForeground(Color.WHITE);
        tblHoiVien.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 13));
        tblHoiVien.getTableHeader().setOpaque(false);
        tblHoiVien.getColumnModel().getColumn(0).setCellRenderer(new AvataTbHoiVien());
        tblHoiVien.getColumnModel().getColumn(5).setCellRenderer(new TimeDatePanel());
        TableColumnModel columnModel = tblHoiVien.getColumnModel();
        columnModel.getColumn(5).setPreferredWidth(10);
        
    }

    private void fillToTable() {
        model = (DefaultTableModel) tblHoiVien.getModel();
        model.setRowCount(0);
        List<Object[]> listHoiVien = hvDAO.getHoiVien();
        for (Object[] hv : listHoiVien) {
            model.addRow(hv);
        }
    }

    private void timKiem() {
        model = (DefaultTableModel) tblHoiVien.getModel();
        model.setRowCount(0);
        List<Object[]> listHoiVien = hvDAO.TimKiemHoiVien("%" + txtTimKiem.getText() + "%", "%" + txtTimKiem.getText() + "%", "%" + txtTimKiem.getText() + "%");
        for (Object[] hv : listHoiVien) {
            model.addRow(hv);
        }
    }

}
