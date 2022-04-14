/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.GoiTapDAO;
import com.group2.entity.GoiTap;
import com.group2.swing.AvataGioTap;
import com.group2.swing.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HieuHoang
 */
public class QLGoiTapUI extends javax.swing.JPanel {

    DefaultTableModel model;
    GoiTapDAO goiTapDAO = new GoiTapDAO();
    List<GoiTap> list = goiTapDAO.selectAll();
    DecimalFormat df = new DecimalFormat("###,###.###");

    /**
     * Creates new form QLGoiTapUI
     */
    public QLGoiTapUI() {
        initComponents();
        designTable();
        fillTable();
    }

    private void designTable() {
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setHorizontalScrollBar(new ScrollBarCustom());
        tblGT.getTableHeader().setBackground(new Color(107, 149, 183));
        tblGT.getTableHeader().setForeground(Color.WHITE);
        tblGT.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 13));
        tblGT.getTableHeader().setOpaque(false);
        tblGT.getColumnModel().getColumn(0).setCellRenderer(new AvataGioTap());

    }

    public void fillTable() {
        String selected = (String) cboGT.getSelectedItem();
        model = (DefaultTableModel) tblGT.getModel();
        model.setRowCount(0);
        for (GoiTap gt : list) {
            if (selected.equals("Tất cả")) {
                Object[] ob = {gt.getMaGT(), gt.getTenGoiTap(), df.format(gt.getGia()) + "₫", gt.getThoiLuong()};
                model.addRow(ob);

            } else if (gt.getMaLoai().trim().equalsIgnoreCase(selected.trim())) {
                Object[] ob = {gt.getMaGT(), gt.getTenGoiTap(), df.format(gt.getGia()) + "₫", gt.getThoiLuong()};
                model.addRow(ob);
            } else {

            }

        }
        model.fireTableDataChanged();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnSua = new javax.swing.JMenuItem();
        gradientBackGround1 = new com.group2.swing.GradientBackGround();
        button1 = new com.group2.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGT = new javax.swing.JTable();
        cboGT = new com.group2.swing.ComboBoxSuggestion();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        gradientBackGround2 = new com.group2.swing.GradientBackGround();
        button2 = new com.group2.swing.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGT1 = new javax.swing.JTable();
        cboGT1 = new com.group2.swing.ComboBoxSuggestion();
        jLabel2 = new javax.swing.JLabel();

        mnSua.setText("Sửa");
        mnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSuaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnSua);

        setOpaque(false);

        gradientBackGround1.setBorderRadius(10);
        gradientBackGround1.setShadowSize(5);

        button1.setBackground(new java.awt.Color(255, 0, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("+ Thêm gói tập");
        button1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        tblGT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblGT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã GT", "Tên gói tập", "Giá", "Thời lượng(ngày)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGT.setRowHeight(25);
        tblGT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGTMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblGTMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblGT);

        cboGT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Gym", "Yoga", "Boxing" }));
        cboGT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGTActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(150, 150, 150));
        jLabel1.setText("Loại gói tập");

        javax.swing.GroupLayout gradientBackGround1Layout = new javax.swing.GroupLayout(gradientBackGround1);
        gradientBackGround1.setLayout(gradientBackGround1Layout);
        gradientBackGround1Layout.setHorizontalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboGT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(410, 410, 410)
                        .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        gradientBackGround1Layout.setVerticalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(cboGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel1.setOpaque(false);

        gradientBackGround2.setBorderRadius(10);
        gradientBackGround2.setShadowSize(5);

        button2.setBackground(new java.awt.Color(255, 0, 51));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("+ Thêm gói tập");
        button2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        tblGT1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblGT1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã GT", "Tên gói tập", "Giá", "Thời lượng(ngày)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGT1.setRowHeight(25);
        tblGT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGT1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGT1);

        cboGT1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Gym", "Yoga", "Boxing" }));
        cboGT1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboGT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGT1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(150, 150, 150));
        jLabel2.setText("Loại gói tập");

        javax.swing.GroupLayout gradientBackGround2Layout = new javax.swing.GroupLayout(gradientBackGround2);
        gradientBackGround2.setLayout(gradientBackGround2Layout);
        gradientBackGround2Layout.setHorizontalGroup(
            gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(gradientBackGround2Layout.createSequentialGroup()
                        .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboGT1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(410, 410, 410)
                        .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        gradientBackGround2Layout.setVerticalGroup(
            gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradientBackGround2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(cboGT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        new ChiTietGoiTapJDailog(true, model).setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void tblGTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGTMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jPopupMenu1.show(tblGT, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblGTMouseClicked

    private void mnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSuaActionPerformed

        GoiTap gt = goiTapDAO.selectById(tblGT.getValueAt(tblGT.getSelectedRow(), 0));
        new ChiTietGoiTapJDailog(false, gt, model).setVisible(true);
    }//GEN-LAST:event_mnSuaActionPerformed

    private void cboGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGTActionPerformed
        // TODO add your handling code here:
        fillTable();

    }//GEN-LAST:event_cboGTActionPerformed

    private void tblGT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGT1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            GoiTap gt = goiTapDAO.selectById(tblGT.getValueAt(tblGT.getSelectedRow(), 0));
            new ChiTietGoiTapJDailog(false, gt, model).setVisible(true);
        }
    }//GEN-LAST:event_tblGT1MouseClicked

    private void cboGT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGT1ActionPerformed

    private void tblGTMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGTMouseReleased
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            GoiTap gt = goiTapDAO.selectById(tblGT.getValueAt(tblGT.getSelectedRow(), 0));
            new ChiTietGoiTapJDailog(false, gt, model).setVisible(true);
        }
    }//GEN-LAST:event_tblGTMouseReleased

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button button1;
    private com.group2.swing.Button button2;
    private com.group2.swing.ComboBoxSuggestion cboGT;
    private com.group2.swing.ComboBoxSuggestion cboGT1;
    private com.group2.swing.GradientBackGround gradientBackGround1;
    private com.group2.swing.GradientBackGround gradientBackGround2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnSua;
    private javax.swing.JTable tblGT;
    private javax.swing.JTable tblGT1;
    // End of variables declaration//GEN-END:variables
}
