/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.NhanVienDAO;
import com.group2.entity.NhanVien;
import com.group2.swing.Alert;
import com.group2.swing.ImageView;
import com.group2.utils.GImage;
import com.group2.utils.MsgBox;
import com.group2.utils.GDate;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HieuHoang
 */
public class ChiTietNhanVienJDailog extends javax.swing.JDialog {
//    kt = true thêm
//   kt  = false sửa

    NhanVienDAO nvDAO = new NhanVienDAO();

    /**
     * Creates new form ChiTietNhanVienJDailog
     */
    public ChiTietNhanVienJDailog(boolean kt, NhanVien nv) {

        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        if (kt == false) {
            titile.setText("Sửa thông tin nhân viên");
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
                imgHinh.setImage(GImage.read("nvIMG/", nv.getHinh()));
                imgHinh.setToolTipText(nv.getHinh());
            } else {
                imgHinh.setImage(GImage.read("khachhangIMG/", "macdinh.png"));
                imgHinh.setToolTipText("macdinh.png");
            }
        } else {
            main.remove(btnSua);
            titile.setText("Thêm thông tin nhân viên mới");
        }
    }

    public ChiTietNhanVienJDailog(boolean kt) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        
        imgHinh.setImage(GImage.read("khachhangIMG/", "macdinh.png"));
        if (kt == false) {
            titile.setText("Sửa thông tin nhân viên");
        } else {
            main.remove(btnSua);
            titile.setText("Thêm thông tin nhân viên mới");

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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        btnLuu = new com.group2.swing.Button();
        btnSua = new com.group2.swing.Button();
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
        titile.setText("Thêm thông tin nhân viên mới");

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

        txtMa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMa.setLabelText("Mã nhân viên");

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau.setLabelText("Mật khẩu");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHoTen.setLabelText("Họ và tên");

        buttonGroup1.add(rdoQL);
        rdoQL.setText("Quản lý");
        rdoQL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buttonGroup1.add(rdoNV);
        rdoNV.setSelected(true);
        rdoNV.setText("Nhân viên");
        rdoNV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Chức vụ");

        buttonGroup1.add(rdoPT);
        rdoPT.setText("PT");
        rdoPT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgaySinh.setLabelText("Ngày sinh");

        btnLuu.setBackground(new java.awt.Color(0, 51, 153));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu nhân viên");
        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 51, 204));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa nhân viên");
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        textAreaScroll1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaScroll1.setLabelText("Địa chỉ");
        textAreaScroll1.setOpaque(false);

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
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(mainLayout.createSequentialGroup()
                                                .addComponent(rdoQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoPT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(titile)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE)))
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
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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
        chonAnh();
    }//GEN-LAST:event_imgHinhMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        themNhanVien();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        suaNhanVien();
    }//GEN-LAST:event_btnSuaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button btnLuu;
    private com.group2.swing.Button btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
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
    NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMa.getText());
        nv.setMatKhau(txtMatKhau.getText());
        nv.setHoTen(txtHoTen.getText());
        nv.setNgaySinh(GDate.toDate(txtNgaySinh.getText(), "yyyy-MM-dd"));
        if (rdoNV.isSelected()) {
            nv.setChucVu("Nhân viên");
        } else if (rdoQL.isSelected()) {
            nv.setChucVu("Quản lý");
        } else {
            nv.setChucVu("PT");
        }
        nv.setHinh(imgHinh.getToolTipText());
        nv.setDiaChi(txtDiaChi.getText());
        return nv;
    }

    private void themNhanVien() {
        NhanVien nv = getForm();
        try {
            nvDAO.insert(nv);
            MsgBox.alert(this, "Thông báo", "Thêm nhân viên thành công!", Alert.AlertType.SUCCESS);

        } catch (Exception e) {
            MsgBox.alert(this, "Thêm nhân viên thất bại !", "Mã nhân viên hoặc số điện thoại đã tồn tại!", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void suaNhanVien() {
        NhanVien nv = getForm();
        try {
            nvDAO.update(nv);
            MsgBox.alert(this, "Thông báo", "Sửa nhân viên thành công!", Alert.AlertType.SUCCESS);

        } catch (Exception e) {
            MsgBox.alert(this, "Sửa nhân viên thất bại !", "Mã nhân viên hoặc số điện thoại đã tồn tại!", Alert.AlertType.ERROR);

            e.printStackTrace();
        }
    }

    public void chonAnh() {
        JFileChooser c = new JFileChooser("nvIMG");
        int rVal = c.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            File file = c.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            GImage.save("nvIMG/", file);
            ImageIcon ic = GImage.read("nvIMG/", file.getName());
            imgHinh.setImage(ic);
            imgHinh.setToolTipText(file.getName());
        }
    }
}
