/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.HoaDonDao;
import com.group2.dao.KhachHangDAO;
import com.group2.dao.ThongKeDAO;
import com.group2.entity.HoaDon;
import com.group2.entity.KhachHang;
import com.group2.swing.Alert;
import com.group2.swing.ScrollBarCustom;
import com.group2.utils.GImage;
import com.group2.utils.MsgBox;
import com.group2.utils.GDate;
import com.group2.utils.Validation;
import java.awt.Color;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author HieuHoang
 */
public class ChiTietKhachHangJDailog extends javax.swing.JDialog {

    KhachHangDAO khDAO = new KhachHangDAO();
    //HoaDonDao hdDAO = new HoaDonDao();
    ThongKeDAO tkDAO = new ThongKeDAO();

    /**
     * Creates new form ChiTietKhachHangJDailog
     *
     */
    KhachHang kh;

    public ChiTietKhachHangJDailog(boolean kt, KhachHang kh) {
        this.kh = kh;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        designJList();
        if (kt == false) {
            titile.setText("Sửa thông tin khách hàng");
            txtMa.setText(kh.getSoDT().trim());
            txtDiaChi.setText(kh.getDiaChi());
            txtHoTen.setText(kh.getHoTen());
            txtEmail.setText(kh.getEmail());
            txtNgaySinh.setText(GDate.toString(kh.getNgaySinh(), "yyyy-MM-dd"));
            if (kh.isGioiTinh() == true) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            if (kh.getHinh() != null) {
                imgHinh.setImage(GImage.read("khachhangIMG/", kh.getHinh()));
                imgHinh.setToolTipText(kh.getHinh());
            } else {
                imgHinh.setImage(GImage.read("khachhangIMG/", "macdinh.png"));
                imgHinh.setToolTipText("macdinh.png");
            }

        } else {
            titile.setText("Thêm thông tin khách hàng mới");
            main.remove(btnSua);
        }
        fillToList();

    }

    public ChiTietKhachHangJDailog(boolean kt) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        designJList();
        imgHinh.setImage(GImage.read("khachhangIMG/", "macdinh.png"));
        if (kt == false) {
            titile.setText("Sửa thông tin khách hàng");
            //main.remove(btnLuu);
        } else {
            titile.setText("Thêm thông tin khách hàng mới");
            main.remove(btnSua);
        }
    }

    DefaultListModel<String> model;

    public void fillToList() {
        model = new DefaultListModel();
        List<Object[]> list = tkDAO.BuyHistory(kh.getSoDT());
        for (Object[] objects : list) {
            model.addElement("Loai:" + objects[0] + " - Time:" + objects[1]);
            jList1.setModel(model);
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
        txtHoTen = new com.group2.swing.TextField();
        rdoNam = new com.group2.swing.RadioButtonCustom();
        rdoNu = new com.group2.swing.RadioButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        txtNgaySinh = new com.group2.swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnSua = new com.group2.swing.Button();
        textAreaScroll1 = new com.group2.swing.TextAreaScroll();
        txtDiaChi = new com.group2.swing.TextArea();
        txtEmail = new com.group2.swing.TextField();

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
        titile.setText("Thêm thông tin khách hàng mới");

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
                .addComponent(imgHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        txtMa.setEditable(false);
        txtMa.setBackground(new java.awt.Color(255, 255, 255));
        txtMa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMa.setLabelText("Số điện thoại");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHoTen.setLabelText("Họ và tên");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Giới tính");

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgaySinh.setLabelText("Ngày sinh");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Lịch sử mua hàng");

        jLabel5.setBackground(new java.awt.Color(102, 0, 153));
        jLabel5.setOpaque(true);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jScrollPane2.setViewportView(jList1);

        btnSua.setBackground(new java.awt.Color(0, 51, 153));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa khách hàng");
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

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setLabelText("Email");

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
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titile)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addGap(3, 3, 3))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(124, 124, 124))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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

        chonAnh();
    }//GEN-LAST:event_imgHinhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        suaKhachHang();

    }//GEN-LAST:event_btnSuaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.group2.swing.ConBtn conBtn1;
    private com.group2.swing.ImageView imgHinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.group2.swing.GradientBackGround main;
    private com.group2.swing.RadioButtonCustom rdoNam;
    private com.group2.swing.RadioButtonCustom rdoNu;
    private com.group2.swing.TextAreaScroll textAreaScroll1;
    private javax.swing.JLabel titile;
    private com.group2.swing.TextArea txtDiaChi;
    private com.group2.swing.TextField txtEmail;
    private com.group2.swing.TextField txtHoTen;
    private com.group2.swing.TextField txtMa;
    private com.group2.swing.TextField txtNgaySinh;
    // End of variables declaration//GEN-END:variables

    private void designJList() {
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setHorizontalScrollBar(new ScrollBarCustom());
    }

    KhachHang getForm() {
        KhachHang kh = new KhachHang();
        kh.setSoDT(txtMa.getText());
        kh.setHoTen(txtHoTen.getText());
        kh.setNgaySinh(GDate.toDate(txtNgaySinh.getText(), "yyyy-MM-dd"));
        kh.setEmail(txtEmail.getText());
        if (rdoNam.isSelected()) {
            kh.setGioiTinh(true);
        } else if (rdoNu.isSelected()) {
            kh.setGioiTinh(false);
        }
        kh.setHinh(imgHinh.getToolTipText());
        kh.setDiaChi(txtDiaChi.getText());
        return kh;
    }

    private void suaKhachHang() {
        KhachHang kh = getForm();
        try {
            //check sđt
            if (Validation.checkExperession(txtMa.getText(), "^(84|0[3|5|7|8|9])[0-9]{8}$") == false) {
                txtMa.requestFocus();
                MsgBox.alert(this, "Lỗi", "Số điện thoại không đúng định dạng", Alert.AlertType.ERROR);
                return;
            }
            //check ho tên
            if (Validation.checkLength(txtHoTen.getText()) == false) {
                txtHoTen.requestFocus();
                MsgBox.alert(this, "Lỗi", "Vui lòng nhập lại họ tên", Alert.AlertType.ERROR);
                return;
            }
            if (new Validation().checkName(txtHoTen.getText()) == false) {
                txtHoTen.requestFocus();
                MsgBox.alert(this, "Lỗi", "Họ tên không đúng định dạng", Alert.AlertType.ERROR);
                return;
            }
            //check Ngay sinh
            if (new Validation().checkDate(txtNgaySinh.getText()) == false) {
                txtNgaySinh.requestFocus();
                MsgBox.alert(this, "Lỗi", "Vui lòng kiểm tra lại định dạng ngày 'yyyy-MM-dd'", Alert.AlertType.ERROR);
                return;
            }
            //check Email
            if (Validation.checkExperession(txtEmail.getText(), "^\\w+@\\w+(\\.\\w+){1,2}$") == false) {
                txtEmail.requestFocus();
                MsgBox.alert(this, "Lỗi", "Vui lòng kiểm tra lại email", Alert.AlertType.ERROR);
                return;
            }
            List<KhachHang> list = khDAO.selectAll();

            for (KhachHang khachHang : list) {
                if (khachHang.equals(kh)) {
                    if (kh.getEmail().equals(khachHang.getEmail())) {
                        //return;
                    }
                } else {
                    if (khachHang.getEmail().equals(kh.getEmail())) {
                        MsgBox.alert(this, "Lỗi", "Email đã tồn tại", Alert.AlertType.ERROR);
                        txtEmail.requestFocus();
                        return;
                    }
                }
            }
            //check Địa chỉ
            if (Validation.checkLength(txtDiaChi.getText()) == false) {
                txtDiaChi.requestFocus();
                MsgBox.alert(this, "Lỗi", "Vui lòng nhập địa chỉ", Alert.AlertType.ERROR);
                return;
            }
            khDAO.update(kh);
            MsgBox.alert(this, "Thông báo", "Cập nhật thông tin khách thành công!", Alert.AlertType.SUCCESS);
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại", "Vui lòng kiểm tra lại thông tin!", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void chonAnh() {
        JFileChooser c = new JFileChooser("khachhangIMG");
        int rVal = c.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            File file = c.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            GImage.save("KhachhangIMG/", file);
            ImageIcon ic = GImage.read("KhachhangIMG/", file.getName());
            imgHinh.setImage(ic);
            imgHinh.setToolTipText(file.getName());
        }
    }

    public void luuKhachHang() {
        try {
            KhachHang kh = new KhachHang();
            kh = getForm();
            khDAO.insert(kh);
            MsgBox.alert(this, "Thành công", "Thêm thành công", Alert.AlertType.SUCCESS);
        } catch (Exception e) {
            MsgBox.alert(this, "THêm mới thất bại", "Vui lòng kiểm tra lại thông tin!", Alert.AlertType.ERROR);

        }

    }

}
