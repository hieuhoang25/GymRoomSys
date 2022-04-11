/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.entity.NhanVien;
import com.group2.utils.GImage;
import java.awt.Color;

/**
 *
 * @author HieuHoang
 */
public class MyAcountJDailog extends javax.swing.JDialog {

    /**
     * Creates new form MyAcountJDailog
     */
    public MyAcountJDailog(NhanVien nv) {

        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        txtMa.setText(nv.getMaNV().trim());
        txtHoTen.setText(nv.getHoTen().trim());
        txtDiaChi.setText(nv.getDiaChi().trim());
        txtMatKhau.setText(nv.getMatKhau().trim());
        txtNgaySinh.setText(nv.getNgaySinh() + "");
        if (nv.getChucVu().equalsIgnoreCase("PT")) {
            rdoPT.setSelected(true);
        } else if (nv.getChucVu().equalsIgnoreCase("Nhân viên")) {
            rdoNV.setSelected(true);
        } else {
            rdoQL.setSelected(true);
        }
        if (nv.getHinh() != null) {
            imgHinh.setImage(GImage.read("nvIMG",nv.getHinh()));
        } else {
            imgHinh.setImage(GImage.read("khachhangIMG/","macdinh.png"));

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

        main = new com.group2.swing.GradientBackGround();
        conBtn1 = new com.group2.swing.ConBtn();
        titile = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imgHinh = new com.group2.swing.ImageView();
        txtMa = new com.group2.swing.TextField();
        txtMatKhau = new com.group2.swing.TextField();
        txtHoTen = new com.group2.swing.TextField();
        rdoQL = new com.group2.swing.RadioButtonCustom();
        rdoNV = new com.group2.swing.RadioButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        rdoPT = new com.group2.swing.RadioButtonCustom();
        txtNgaySinh = new com.group2.swing.TextField();
        textAreaScroll1 = new com.group2.swing.TextAreaScroll();
        txtDiaChi = new com.group2.swing.TextArea();

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
        titile.setText("Thông tin nhân viên");

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)), "Hình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel1.setOpaque(false);

        imgHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(imgHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(imgHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        txtMa.setEditable(false);
        txtMa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMa.setLabelText("Mã nhân viên");

        txtMatKhau.setEditable(false);
        txtMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau.setLabelText("Mật khẩu");

        txtHoTen.setEditable(false);
        txtHoTen.setBackground(new java.awt.Color(255, 255, 255));
        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHoTen.setLabelText("Họ và tên");

        rdoQL.setText("Quản lý");
        rdoQL.setEnabled(false);
        rdoQL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        rdoNV.setText("Nhân viên");
        rdoNV.setEnabled(false);
        rdoNV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Chức vụ");

        rdoPT.setText("PT");
        rdoPT.setEnabled(false);
        rdoPT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNgaySinh.setEditable(false);
        txtNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgaySinh.setLabelText("Ngày sinh");

        textAreaScroll1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaScroll1.setLabelText("Địa chỉ");
        textAreaScroll1.setOpaque(false);

        txtDiaChi.setEditable(false);
        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaScroll1.setViewportView(txtDiaChi);

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
                        .addGap(20, 20, 20)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(mainLayout.createSequentialGroup()
                                                .addComponent(rdoQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoPT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(titile)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rdoQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(54, 54, 54))
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

    private void imgHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgHinhMouseClicked
        // TODO add your handling code here:
        // lấy ảnh

    }//GEN-LAST:event_imgHinhMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.ConBtn conBtn1;
    private com.group2.swing.ImageView imgHinh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.group2.swing.GradientBackGround main;
    private com.group2.swing.RadioButtonCustom rdoNV;
    private com.group2.swing.RadioButtonCustom rdoPT;
    private com.group2.swing.RadioButtonCustom rdoQL;
    private com.group2.swing.TextAreaScroll textAreaScroll1;
    private javax.swing.JLabel titile;
    private com.group2.swing.TextArea txtDiaChi;
    private com.group2.swing.TextField txtHoTen;
    private com.group2.swing.TextField txtMa;
    private com.group2.swing.TextField txtMatKhau;
    private com.group2.swing.TextField txtNgaySinh;
    // End of variables declaration//GEN-END:variables
}
