/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.NhanVienDAO;
import com.group2.swing.Alert;
import com.group2.utils.Auth;
import com.group2.utils.MsgBox;
import java.awt.Color;

/**
 *
 * @author HieuHoang
 */
public class DoiMatKhauJDailog extends javax.swing.JDialog {

    NhanVienDAO nv = new NhanVienDAO();

    /**
     * Creates new form DoiMatKhauJDailog
     */
    public DoiMatKhauJDailog() {

        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new com.group2.swing.GradientBackGround();
        conBtn1 = new com.group2.swing.ConBtn();
        titile = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new com.group2.swing.Button();
        txtMatKhau = new com.group2.swing.PasswordField();
        txtMatKhau1 = new com.group2.swing.PasswordField();
        txtMatKhau2 = new com.group2.swing.PasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        main.setBorderRadius(10);

        conBtn1.setBackground(new java.awt.Color(204, 0, 51));
        conBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBtn1ActionPerformed(evt);
            }
        });

        titile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titile.setForeground(new java.awt.Color(0, 102, 153));
        titile.setText("Đổi mật khẩu");

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setOpaque(true);

        button1.setBackground(new java.awt.Color(0, 102, 204));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Lưu mật khẩu");
        button1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau.setLabelText("Mật khẩu cũ");

        txtMatKhau1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau1.setLabelText("Mật khẩu mới");

        txtMatKhau2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau2.setLabelText("Nhập lại mật khẩu mới");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titile)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                    .addComponent(txtMatKhau2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMatKhau1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titile)
                    .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conBtn1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_conBtn1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        doiMatKhau();
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button button1;
    private com.group2.swing.ConBtn conBtn1;
    private javax.swing.JLabel jLabel2;
    private com.group2.swing.GradientBackGround main;
    private javax.swing.JLabel titile;
    private com.group2.swing.PasswordField txtMatKhau;
    private com.group2.swing.PasswordField txtMatKhau1;
    private com.group2.swing.PasswordField txtMatKhau2;
    // End of variables declaration//GEN-END:variables

    private void doiMatKhau() {
        System.out.println(Auth.user.getMatKhau());
        if (Auth.user.getMatKhau().equals(txtMatKhau.getText().trim())) {
            if (txtMatKhau1.getText().trim().equals(txtMatKhau2.getText().trim())) {
                Auth.user.setMatKhau(txtMatKhau1.getText().trim());
                nv.update(Auth.user);
                MsgBox.alert(this, "Thông báo", "Cập nhật mật khẩu thành công!", Alert.AlertType.SUCCESS);
                dispose();

            } else {
                MsgBox.alert(null, "Cập nhật mật khẩu thất bại!", "Mật khẩu không khớp!", Alert.AlertType.ERROR);

            }
        } else {
            MsgBox.alert(null, "Cập nhật mật khẩu thất bại!", "Mật khẩu cũ không đúng!", Alert.AlertType.ERROR);
        }
    }
}
