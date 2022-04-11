/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.SanPhamDAO;
import com.group2.entity.SanPham;
import com.group2.swing.Alert;
import com.group2.utils.GJDBC;
import com.group2.utils.GImage;
import com.group2.utils.MsgBox;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author HieuHoang
 */
public class ChiTietSanPhamJDailog extends javax.swing.JDialog {

    SanPhamDAO spDAO = new SanPhamDAO();
    SanPhamUI spUI;

    /**
     * Creates new form ChiTietSanPhamUI
     */
    public ChiTietSanPhamJDailog(boolean kt, SanPham sp) {

        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        if (kt == true) {
            titile.setText("Sửa thông tin sản phẩm");
            cboLoaiSP.setSelectedItem(GJDBC.value("select TenSP from sanpham where masp = ?", sp.getTenLoai()));
            txtTen.setText(sp.getTenSP().trim());
            txtDonGia.setText(sp.getDonGia() + "");
            txtSoLuong.setText(sp.getSoLuong() + "");
            txtNhaSanXuat.setText(sp.getNhaSanXuat().trim());
            txtGhiChu.setText((sp.getGhiChu() + "").trim());
            txtMa.setText(sp.getMaSP().trim());
            if (sp.getHinh() != null) {
                imageView1.setImage(GImage.read("sanphamIMG/",sp.getHinh()));
            } else {
                imageView1.setImage(GImage.read("khachhangIMG","macdinh.png"));
            }
            main.remove(btnLuu);
        } else {
            titile.setText("Thêm sản phẩm mới");
            main.remove(btnSua);
        }
    }

    public ChiTietSanPhamJDailog(boolean kt) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        if (kt == true) {
            titile.setText("Sửa thông tin sản phẩm");
            main.remove(btnLuu);
        } else {
            titile.setText("Thêm sản phẩm mới");
            main.remove(btnSua);
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
        titile = new javax.swing.JLabel();
        conBtn1 = new com.group2.swing.ConBtn();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imageView1 = new com.group2.swing.ImageView();
        txtTen = new com.group2.swing.TextField();
        txtDonGia = new com.group2.swing.TextField();
        txtNhaSanXuat = new com.group2.swing.TextField();
        textAreaScroll1 = new com.group2.swing.TextAreaScroll();
        txtGhiChu = new com.group2.swing.TextArea();
        btnSua = new com.group2.swing.Button();
        txtSoLuong = new com.group2.swing.TextField();
        btnLuu = new com.group2.swing.Button();
        txtMa = new com.group2.swing.TextField();
        cboLoaiSP = new com.group2.swing.ComboBoxSuggestion();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        main.setBorderRadius(10);

        titile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titile.setText("Thông tin chi tiết sản phẩm");

        conBtn1.setBackground(new java.awt.Color(255, 0, 0));
        conBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBtn1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(51, 0, 204));
        jLabel2.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel1.setOpaque(false);

        imageView1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageView1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTen.setLabelText("Tên sản phẩm");

        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDonGia.setLabelText("Đơn giá");

        txtNhaSanXuat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNhaSanXuat.setLabelText("Nhà sản xuất");

        textAreaScroll1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaScroll1.setLabelText("Ghi chú");
        textAreaScroll1.setOpaque(false);

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaScroll1.setViewportView(txtGhiChu);

        btnSua.setBackground(new java.awt.Color(0, 102, 204));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa sản phẩm");
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoLuong.setLabelText("Số lượng");

        btnLuu.setBackground(new java.awt.Color(0, 102, 204));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu sản phẩm");
        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtMa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMa.setLabelText("Mã sản phẩm");

        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sữa tăng cân", "Sữa tăng cơ", "Bao tay", "Giày thể thao", "Quần Thể Thao", "Áo thể thao" }));
        cboLoaiSP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(150, 150, 150));
        jLabel1.setText("Loại sản phẩm");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(titile, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNhaSanXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                            .addComponent(cboLoaiSP, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(10, 10, 10)))
                .addContainerGap())
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                    .addContainerGap(334, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(titile))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(conBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                    .addContainerGap(435, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        themSanPham();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        suaSanPham();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void imageView1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageView1MouseClicked
        chonAnh();
    }//GEN-LAST:event_imageView1MouseClicked

    private void cboLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSPActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboLoaiSPActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button btnLuu;
    private com.group2.swing.Button btnSua;
    private com.group2.swing.ComboBoxSuggestion cboLoaiSP;
    private com.group2.swing.ConBtn conBtn1;
    private com.group2.swing.ImageView imageView1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.group2.swing.GradientBackGround main;
    private com.group2.swing.TextAreaScroll textAreaScroll1;
    private javax.swing.JLabel titile;
    private com.group2.swing.TextField txtDonGia;
    private com.group2.swing.TextArea txtGhiChu;
    private com.group2.swing.TextField txtMa;
    private com.group2.swing.TextField txtNhaSanXuat;
    private com.group2.swing.TextField txtSoLuong;
    private com.group2.swing.TextField txtTen;
    // End of variables declaration//GEN-END:variables
    SanPham getForm() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtMa.getText());
        sp.setTenSP(txtTen.getText());
        sp.setDonGia(Float.parseFloat(txtDonGia.getText()));
        sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        sp.setNhaSanXuat(txtNhaSanXuat.getText());
        sp.setGhiChu(txtGhiChu.getText());
        sp.setMaLoai(String.valueOf(GJDBC.value("select MaSP from sanpham where TenSP = ? ",String.valueOf(cboLoaiSP.getSelectedItem()))));
        sp.setHinh(imageView1.getToolTipText());
        return sp;
    }

    public void suaSanPham() {
        SanPham sp = getForm();
        try {
            spDAO.update(sp);
            MsgBox.alert(this, "Thông báo", "Cập nhật sản phẩm thành công!", Alert.AlertType.SUCCESS);

        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại", "Vui lòng kiểm tra lại thông tin", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void themSanPham() {
        SanPham sp = getForm();
        try {
            spDAO.insert(sp);
            MsgBox.alert(this, "Thông báo", "Cập nhật sản phẩm thành công!", Alert.AlertType.SUCCESS);

        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại", "Vui lòng kiểm tra lại thông tin", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void chonAnh() {
        JFileChooser c = new JFileChooser("sanphamIMG");
        int rVal = c.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            File file = c.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            GImage.save("sanphamIMG/",file);
            ImageIcon ic = GImage.read("sanphamIMG/",file.getName());
            imageView1.setImage(ic);
            imageView1.setToolTipText(file.getName());
        }
    }
}
