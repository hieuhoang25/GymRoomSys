/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.GoiTapDAO;
import com.group2.entity.GoiTap;
import com.group2.swing.Alert;
import com.group2.utils.MsgBox;
import com.group2.utils.Validation;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author HieuHoang
 */
public class ChiTietGoiTapJDailog extends javax.swing.JDialog {

    GoiTapDAO dao = new GoiTapDAO();
    boolean check;
    DefaultTableModel model1;

    /**
     * Creates new form ChiTietGoiTapJDailog
     */
    public ChiTietGoiTapJDailog(boolean c, GoiTap gt, DefaultTableModel model) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        check = c;
        txtGia.setText(String.valueOf(gt.getGia()));
        txtMaGT.setText(gt.getMaGT().trim());
        txtTenGT.setText(gt.getTenGoiTap());
        txtThoiLuong.setText(String.valueOf(gt.getThoiLuong()));
        System.out.println((gt.getMaLoai().substring(0, 1).toUpperCase() + gt.getMaLoai().substring(1, gt.getMaLoai().length())));
        cboLoaiGT.setSelectedItem((gt.getMaLoai().substring(0, 1).toUpperCase() + gt.getMaLoai().substring(1, gt.getMaLoai().length())).trim());
        model1 = model;
    }

    ChiTietGoiTapJDailog() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
    }

    ChiTietGoiTapJDailog(boolean b, DefaultTableModel model) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        check = b;
        model1 = model;
    }

    public void fillTable(DefaultTableModel m) {
        m.setRowCount(0);
        m.setRowCount(0);
        for (GoiTap gt : dao.selectAll()) {

            Object[] ob = {gt.getMaGT(), gt.getTenGoiTap(), gt.getGia(), gt.getThoiLuong()};
            m.addRow(ob);

        }

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
        conBtn1 = new com.group2.swing.ConBtn();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaGT = new com.group2.swing.TextField();
        txtTenGT = new com.group2.swing.TextField();
        txtGia = new com.group2.swing.TextField();
        txtThoiLuong = new com.group2.swing.TextField();
        btnLuu = new com.group2.swing.Button();
        jLabel3 = new javax.swing.JLabel();
        cboLoaiGT = new com.group2.swing.ComboBoxSuggestion();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        gradientBackGround1.setBorderRadius(10);

        conBtn1.setBackground(new java.awt.Color(204, 0, 0));
        conBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBtn1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Thông tin chi tiết gói tập");

        jLabel2.setBackground(new java.awt.Color(0, 102, 204));
        jLabel2.setOpaque(true);

        txtMaGT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaGT.setLabelText("Mã gói tập");

        txtTenGT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenGT.setLabelText("Tên gói tập");

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGia.setLabelText("Giá");

        txtThoiLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtThoiLuong.setLabelText("Thời lượng");

        btnLuu.setBackground(new java.awt.Color(0, 102, 204));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu gói tập");
        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Loại gói");

        cboLoaiGT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gym", "Boxing", "Yoga" }));
        cboLoaiGT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout gradientBackGround1Layout = new javax.swing.GroupLayout(gradientBackGround1);
        gradientBackGround1.setLayout(gradientBackGround1Layout);
        gradientBackGround1Layout.setHorizontalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                                .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaGT, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                                    .addComponent(txtTenGT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLuu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoaiGT, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        gradientBackGround1Layout.setVerticalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtMaGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(cboLoaiGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conBtn1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_conBtn1ActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (check) {
             //check ma
            if (Validation.checkLength(txtMaGT.getText()) == false || txtMaGT.getText().isEmpty()) {
                MsgBox.alert(this, "Lỗi", "Vui lòng kiểm tra lại mã gói tập", Alert.AlertType.ERROR);
                txtMaGT.requestFocus();
                return;
            }
            //check tên
            if (Validation.checkLength(txtTenGT.getText()) == false) {
                MsgBox.alert(this, "Lỗi", "Vui lòng kiểm tra lại tên gói tập", Alert.AlertType.ERROR);
                txtTenGT.requestFocus();
                return;
            }
            //check giá
            if (Validation.checkDouble(txtGia.getText()) == false || txtMaGT.equals("")) {
                MsgBox.alert(this, "Thông báo", "Vui lòng kiểm tra lại giá", Alert.AlertType.ERROR);
                txtGia.requestFocus();
                return;
            }
            //check thời lượng
            if (Validation.checkInt(txtThoiLuong.getText()) == false || txtThoiLuong.equals("")) {
                MsgBox.alert(this, "Thông báo", "Vui lòng kiểm tra lại thời lượng", Alert.AlertType.ERROR);
                txtThoiLuong.requestFocus();
                return;
            }
            //
            GoiTap gt = new GoiTap();
            gt.setGia(Float.valueOf(txtGia.getText()));
            gt.setMaGT(txtMaGT.getText());
            gt.setMaLoai(StringUtils.lowerCase(cboLoaiGT.getSelectedItem().toString()));
            gt.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
            gt.setTenGoiTap(txtTenGT.getText());
           
            dao.insert(gt);
            fillTable(model1);
            MsgBox.alert(ChiTietGoiTapJDailog.this, "Thông báo", "Thêm thành công", Alert.AlertType.SUCCESS);
            this.dispose();
            new QLGoiTapUI().setVisible(true);

        } else {
            GoiTap gt = new GoiTap();
            gt.setGia(Float.valueOf(txtGia.getText()));
            gt.setMaGT(txtMaGT.getText());
            gt.setMaLoai(StringUtils.lowerCase(cboLoaiGT.getSelectedItem().toString()));
            gt.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
            gt.setTenGoiTap(txtTenGT.getText());
            dao.update(gt);
            fillTable(model1);
            MsgBox.alert(ChiTietGoiTapJDailog.this, "Thông báo", "Thêm thành công", Alert.AlertType.SUCCESS);
            this.dispose();
            new QLGoiTapUI().setVisible(true);
        }

    }//GEN-LAST:event_btnLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button btnLuu;
    private com.group2.swing.ComboBoxSuggestion cboLoaiGT;
    private com.group2.swing.ConBtn conBtn1;
    private com.group2.swing.GradientBackGround gradientBackGround1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.group2.swing.TextField txtGia;
    private com.group2.swing.TextField txtMaGT;
    private com.group2.swing.TextField txtTenGT;
    private com.group2.swing.TextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
