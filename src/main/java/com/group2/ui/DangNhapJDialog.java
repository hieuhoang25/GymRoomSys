/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.NhanVienDAO;
import com.group2.entity.NhanVien;
import com.group2.swing.Alert;
import com.group2.swing.Slide;
import com.group2.utils.Auth;
import com.group2.utils.MsgBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HieuHoang
 */
public class DangNhapJDialog extends javax.swing.JFrame {

    NhanVienDAO nvDAO = new NhanVienDAO();

    /**
     * Creates new form DangNhapJDialog
     */
    public DangNhapJDialog() {
        initComponents();
        getContentPane().setBackground(Color.white);
        slideshow1.initSlideshow(new Slide(new ImageIcon(getClass().getResource("/com/group2/icons/logo2.PNG"))), new Slide(new ImageIcon(getClass().getResource("/com/group2/icons/dnbk1.jpg"))), new Slide(new ImageIcon(getClass().getResource("/com/group2/icons/dnbk3.jpg"))));

    }

    DangNhapJDialog(GymSysJFrame aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conBtn1 = new com.group2.swing.ConBtn();
        conBtn3 = new com.group2.swing.ConBtn();
        jLabel1 = new javax.swing.JLabel();
        txtTenDangNhap = new com.group2.swing.TextField();
        txtMatKhau = new com.group2.swing.PasswordField();
        btnDangNhap = new com.group2.swing.Button();
        jCheckBoxCustom1 = new com.group2.swing.JCheckBoxCustom();
        slideshow1 = new com.group2.swing.Slideshow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        conBtn1.setBackground(new java.awt.Color(0, 153, 102));
        conBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBtn1ActionPerformed(evt);
            }
        });

        conBtn3.setBackground(new java.awt.Color(204, 0, 51));
        conBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBtn3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Candara", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Đăng Nhập");

        txtTenDangNhap.setText("NV01");
        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenDangNhap.setLabelText("Tên đăng nhập");
        txtTenDangNhap.setLineColor(new java.awt.Color(69, 124, 235));
        txtTenDangNhap.setSelectionColor(new java.awt.Color(69, 124, 235));

        txtMatKhau.setEchoChar('\u2022');
        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau.setLabelText("Mật khẩu");
        txtMatKhau.setLineColor(new java.awt.Color(69, 124, 235));
        txtMatKhau.setSelectionColor(new java.awt.Color(69, 124, 235));

        btnDangNhap.setBackground(new java.awt.Color(0, 102, 153));
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        jCheckBoxCustom1.setText("Hiển thị mật khẩu");
        jCheckBoxCustom1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBoxCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCustom1ActionPerformed(evt);
            }
        });

        slideshow1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideshow1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addComponent(slideshow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCustom1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxCustom1.isSelected()) {
            txtMatKhau.setEchoChar((char) 0);
            jCheckBoxCustom1.setText("Ẩn mật khẩu");
        } else {
            txtMatKhau.setEchoChar('\u2022');
            jCheckBoxCustom1.setText("Hiển thị mật khẩu");
        }
    }//GEN-LAST:event_jCheckBoxCustom1ActionPerformed

    private void conBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conBtn3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_conBtn3ActionPerformed

    private void conBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conBtn1ActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_conBtn1ActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapJDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button btnDangNhap;
    private com.group2.swing.ConBtn conBtn1;
    private com.group2.swing.ConBtn conBtn3;
    private com.group2.swing.JCheckBoxCustom jCheckBoxCustom1;
    private javax.swing.JLabel jLabel1;
    private com.group2.swing.Slideshow slideshow1;
    private com.group2.swing.PasswordField txtMatKhau;
    private com.group2.swing.TextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
void dangNhap() {
        String TenDangNhapString = txtTenDangNhap.getText().trim();
        String MatKhauString = new String(txtMatKhau.getPassword());
        NhanVien nv = nvDAO.selectById(TenDangNhapString);

        if (!nv.getMaNV().trim().equals(TenDangNhapString)) {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập");
            MsgBox.alert(this, "Đăng nhập thất bại", "Tên đăng nhập hoặc mật khẩu không chính xác !", Alert.AlertType.ERROR);
        } else {
            if (!nv.getMatKhau().trim().equals(MatKhauString)) {
                MsgBox.alert(this, "Đăng nhập thất bại", "Tên đăng nhập hoặc mật khẩu không chính xác !", Alert.AlertType.ERROR);

            } else {
                MsgBox.alert(this, "Thông báo", "Đăng nhập thành công!", Alert.AlertType.SUCCESS);
                Auth.user = nv;
                this.dispose();
                new GymSysJFrame().setVisible(true);

            }
        }
    }
}
