/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.GoiTapDAO;
import com.group2.dao.HoaDonCTDAO;
import com.group2.dao.HoiVienDAO;
import com.group2.dao.KhachHangDAO;
import com.group2.entity.GioHangGT;
import com.group2.entity.GoiTap;
import com.group2.entity.HoiVien;
import com.group2.entity.KhachHang;
import com.group2.swing.Alert;
import com.group2.swing.GioHangGTPanel;
import com.group2.swing.ItemCartGTPanel;
import com.group2.swing.ScrollBarCustom;
import com.group2.utils.Auth;
import com.group2.utils.BillGT;
import com.group2.utils.GImage;
import com.group2.utils.MsgBox;
import com.group2.utils.GDate;
import com.group2.utils.TakePicture;
import com.group2.utils.Validation;
import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author HieuHoang
 */
public class HoaDonGoiTapJDailog extends javax.swing.JDialog {

    GioHangGTPanel gioHangGTPanel;
    DecimalFormat df = new DecimalFormat("###,###.###");
    static List<String> clone = new ArrayList<>();
    Validation v = new Validation();

    /**
     * Creates new form ChiTietGoiTap1JDailog
     */
    public HoaDonGoiTapJDailog(GioHangGTPanel gioHangGTPanel) {

        clearClone();
        this.gioHangGTPanel = gioHangGTPanel;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);
        listItemGT.setLayout(new MigLayout("wrap 1"));
        fillGTToPanel();
        designPanel();
        imgHinh.setImage(GImage.read("khachhangIMG/", "macdinh.png"));
        f = new File("khachhangIMG/", "macdinh.png");
        if (!GymSysJFrame.maKH.equals("")) {
            loadDataOfPerSon();
            imgHinh.setImage(GImage.read("khachhangIMG/", GymSysJFrame.maKH + ".png"));
            f = new File("khachhangIMG/", GymSysJFrame.maKH + ".png");
        }
        txtTongTien.setText(df.format(GioHangGT.tongTienGH()) + "₫");
        tongTienTT.setText(df.format(GioHangGT.tienThanhToan()) + "₫");

    }

    public void clearClone() {
        if (clone.size() != 7) {
            for (int i = 0; i < 7; i++) {
                clone.add(i, "");
            }
        }
    }

    public boolean check() {
        if (v.checkName(txtHoVaTen.getText()) == false) {
            MsgBox.alert(HoaDonGoiTapJDailog.this, "Lỗi", "Tên không hợp lệ", Alert.AlertType.ERROR);
            txtHoVaTen.requestFocus();
            return false;
        } else if (v.checkExperession(txtSDT.getText(), "^(84|0[3|5|7|8|9])[0-9]{8}$") == false) {
            MsgBox.alert(this, "Lỗi", "Số điện thoại không đúng định dạng", Alert.AlertType.ERROR);
            txtSDT.requestFocus();
            return false;
        } else if (v.checkDate(txtNgaySinh.getText()) == false) {
            MsgBox.alert(HoaDonGoiTapJDailog.this, "Lỗi", "Vui lòng kiểm tra lại định dạng ngày 'dd/MM/yyyy'", Alert.AlertType.ERROR);
            txtNgaySinh.requestFocus();
            return false;
        } else if (v.checkEmail(txtEmail.getText()) == false) {
            MsgBox.alert(HoaDonGoiTapJDailog.this, "Lỗi", "Email không hợp lệ", Alert.AlertType.ERROR);
            txtEmail.requestFocus();
            return false;
        } else if (v.checkLength(txtDiaChi.getText()) == false) {
            MsgBox.alert(HoaDonGoiTapJDailog.this, "Lỗi", "Địa chỉ không được bỏ trống", Alert.AlertType.ERROR);
            txtDiaChi.requestFocus();
            return false;
        }
        return true;
    }

    public void loadDataOfPerSon() {
        List<KhachHang> kh = daoKH.selectNotInCourse(GymSysJFrame.maKH);
        if (kh.size() > 0) {
            txtSDT.setText(kh.get(0).getSoDT());
            txtDiaChi.setText(kh.get(0).getDiaChi());
            txtHoVaTen.setText(kh.get(0).getHoTen());
            txtNgaySinh.setText(GDate.toString(kh.get(0).getNgaySinh(), "dd/MM/yyyy"));
            if (kh.get(0).isGioiTinh() == true) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtEmail.setText(kh.get(0).getEmail());
            float tienKM = checkVIP(hdctdao.tongChiTieuKH(kh.get(0).getSoDT()));
            giamGia.setText((int) (tienKM * 100) + "%");

            GioHangGT.giamGia = tienKM;
            txtTongTien.setText(df.format(GioHangGT.tongTienGH()) + "₫");
            tongTienTT.setText(df.format(GioHangGT.tienThanhToan()) + "₫");

        } else {
            txtSDT.setText(GymSysJFrame.maKH);
            txtDiaChi.setText(clone.get(4));
            if (clone.get(1).equals("nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            if (clone.get(5).equals("true")) {
                rdoTienMat.setSelected(true);
            } else {
                rdoThe.setSelected(true);
            }
            txtHoVaTen.setText(clone.get(0));
            txtNgaySinh.setText(clone.get(2));
            giamGia.setText("0%");
            GioHangGT.giamGia = 0;
            txtEmail.setText(clone.get(3));
            txtGhiChu.setText(clone.get(6));
            txtTongTien.setText(df.format(GioHangGT.tongTienGH()) + "₫");
            tongTienTT.setText(df.format(GioHangGT.tienThanhToan()) + "₫");
            imgHinh.setImage(new ImageIcon("khachhangIMG/" + "macdinh.png"));
            GioHangGT.giamGia = 0;
            txtTongTien.setText(df.format(GioHangGT.tongTienGH()) + "₫");
            tongTienTT.setText(df.format(GioHangGT.tienThanhToan()) + "₫");
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        gradientBackGround1 = new com.group2.swing.GradientBackGround();
        conBtn2 = new com.group2.swing.ConBtn();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gradientBackGround2 = new com.group2.swing.GradientBackGround();
        txtSDT = new com.group2.swing.TextField();
        txtHoVaTen = new com.group2.swing.TextField();
        rdoNam = new com.group2.swing.RadioButtonCustom();
        rdoNu = new com.group2.swing.RadioButtonCustom();
        txtNgaySinh = new com.group2.swing.TextField();
        txtEmail = new com.group2.swing.TextField();
        textAreaScroll1 = new com.group2.swing.TextAreaScroll();
        txtDiaChi = new com.group2.swing.TextArea();
        jPanel1 = new javax.swing.JPanel();
        imgHinh = new com.group2.swing.ImageView();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        rdoTienMat = new com.group2.swing.RadioButtonCustom();
        rdoThe = new com.group2.swing.RadioButtonCustom();
        jLabel6 = new javax.swing.JLabel();
        gradientBackGround3 = new com.group2.swing.GradientBackGround();
        jScrollPane2 = new javax.swing.JScrollPane();
        listItemGT = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtTongTien = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        giamGia = new javax.swing.JLabel();
        tongTienTT = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnThanhToan = new com.group2.swing.Button();
        textAreaScroll2 = new com.group2.swing.TextAreaScroll();
        txtGhiChu = new com.group2.swing.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);

        gradientBackGround1.setBorderRadius(10);

        conBtn2.setBackground(new java.awt.Color(204, 0, 0));
        conBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBtn2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Hóa đơn gói tập");

        jLabel2.setBackground(new java.awt.Color(204, 0, 0));
        jLabel2.setOpaque(true);

        gradientBackGround2.setBorderRadius(5);
        gradientBackGround2.setShadowOpacity(0.3F);

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSDT.setLabelText("Số điện thoại");
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });

        txtHoVaTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHoVaTen.setLabelText("Họ và tên");
        txtHoVaTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoVaTenKeyReleased(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgaySinh.setLabelText("Ngày sinh");
        txtNgaySinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNgaySinhKeyReleased(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setLabelText("Email");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        textAreaScroll1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaScroll1.setLabelText("Địa chỉ");
        textAreaScroll1.setOpaque(false);

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiaChiKeyReleased(evt);
            }
        });
        textAreaScroll1.setViewportView(txtDiaChi);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)), "Hình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel1.setOpaque(false);

        imgHinh.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/group2/icons/macdinh.png"))); // NOI18N
        imgHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 78, 146));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin khách hàng");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(62, 197, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Phương thức thanh toán");

        buttonGroup2.add(rdoTienMat);
        rdoTienMat.setSelected(true);
        rdoTienMat.setText("Thanh toán bằng tiền mặt");
        rdoTienMat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoTienMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTienMatActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoThe);
        rdoThe.setText("Thanh toán trực tuyến(Momo, Ví điện tử VNPAY, Visa)");
        rdoThe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdoThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTheActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Giới tính");

        javax.swing.GroupLayout gradientBackGround2Layout = new javax.swing.GroupLayout(gradientBackGround2);
        gradientBackGround2.setLayout(gradientBackGround2Layout);
        gradientBackGround2Layout.setHorizontalGroup(
            gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBackGround2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(gradientBackGround2Layout.createSequentialGroup()
                .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBackGround2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBackGround2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoThe, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(gradientBackGround2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(gradientBackGround2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(gradientBackGround2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(gradientBackGround2Layout.createSequentialGroup()
                                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gradientBackGround2Layout.setVerticalGroup(
            gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradientBackGround2Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gradientBackGround2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gradientBackGround3.setBorderRadius(5);
        gradientBackGround3.setShadowOpacity(0.3F);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listItemGT.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout listItemGTLayout = new javax.swing.GroupLayout(listItemGT);
        listItemGT.setLayout(listItemGTLayout);
        listItemGTLayout.setHorizontalGroup(
            listItemGTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        listItemGTLayout.setVerticalGroup(
            listItemGTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(listItemGT);

        jPanel3.setBackground(new java.awt.Color(246, 250, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tên gói tập");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Đơn giá");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(125, 115, 208));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Giỏ hàng gói tập");

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTongTien.setText("0₫");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TT:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Giảm giá:");

        giamGia.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        giamGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        giamGia.setText("0%");

        tongTienTT.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tongTienTT.setForeground(new java.awt.Color(204, 0, 0));
        tongTienTT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tongTienTT.setText("0₫");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cần thanh toán:");

        btnThanhToan.setBackground(new java.awt.Color(204, 0, 0));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        textAreaScroll2.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaScroll2.setLabelText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGhiChu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGhiChuKeyReleased(evt);
            }
        });
        textAreaScroll2.setViewportView(txtGhiChu);

        javax.swing.GroupLayout gradientBackGround3Layout = new javax.swing.GroupLayout(gradientBackGround3);
        gradientBackGround3.setLayout(gradientBackGround3Layout);
        gradientBackGround3Layout.setHorizontalGroup(
            gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBackGround3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradientBackGround3Layout.createSequentialGroup()
                        .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(giamGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tongTienTT, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(gradientBackGround3Layout.createSequentialGroup()
                .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(gradientBackGround3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBackGround3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAreaScroll2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        gradientBackGround3Layout.setVerticalGroup(
            gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(txtTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(giamGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradientBackGround3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(tongTienTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout gradientBackGround1Layout = new javax.swing.GroupLayout(gradientBackGround1);
        gradientBackGround1.setLayout(gradientBackGround1Layout);
        gradientBackGround1Layout.setHorizontalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addComponent(gradientBackGround2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gradientBackGround3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gradientBackGround1Layout.setVerticalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(conBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradientBackGround2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradientBackGround3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBackGround1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void conBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conBtn2ActionPerformed
        // TODO add your handling code here:
        dispose();
        clone.clear();
        GymSysJFrame.maKH = "";
    }//GEN-LAST:event_conBtn2ActionPerformed


    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed

    }//GEN-LAST:event_txtSDTActionPerformed
    GoiTapDAO dao = new GoiTapDAO();
    List<GoiTap> list = dao.selectAll();
    KhachHangDAO daoKH = new KhachHangDAO();
    List<KhachHang> listKH = daoKH.selectAll();
    JFileChooser jf = new JFileChooser("khachhangIMG/");
    HoaDonCTDAO hdctdao = new HoaDonCTDAO();
    byte[] data;
    File f;
    DefaultTableModel model;
    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
      
        String keyword = txtSDT.getText();
        GymSysJFrame.maKH = keyword;
        List<KhachHang> kh = daoKH.selectNotInCourse(keyword);

        if (kh.size() > 0) {
            txtDiaChi.setText(kh.get(0).getDiaChi());
            txtHoVaTen.setText(kh.get(0).getHoTen());
            txtNgaySinh.setText(GDate.toString(kh.get(0).getNgaySinh(), "dd/MM/yyyy"));
//          GImage.read("khachhangIMG/", kh.get(0).getHinh() == null ? "macdinh.png":GImage.read("khachhangIMG/", kh.get(0).getHinh()));
            imgHinh.setImage(GImage.read("khachhangIMG/", kh.get(0).getHinh() == null ? "macdinh.png" : kh.get(0).getHinh()));
            f = new File("khachhangIMG/", kh.get(0).getHinh() == null ? "macdinh.png" : kh.get(0).getHinh());
            if (kh.get(0).isGioiTinh() == true) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtEmail.setText(kh.get(0).getEmail());
            float tienKM = checkVIP(hdctdao.tongChiTieuKH(kh.get(0).getSoDT()));
            giamGia.setText(Integer.valueOf((int) (tienKM * 100)) + "%");
            GioHangGT.giamGia = tienKM;
            txtTongTien.setText(df.format(GioHangGT.tongTienGH()) + "₫");
            tongTienTT.setText(df.format(GioHangGT.tienThanhToan()) + "₫");
        } else {

            txtDiaChi.setText("");
            rdoNam.setSelected(true);
            rdoTienMat.setSelected(true);
            txtHoVaTen.setText("");
            txtNgaySinh.setText("");
            giamGia.setText("0%");
            GioHangGT.giamGia = 0;
            txtEmail.setText("");
            txtGhiChu.setText("");
            txtTongTien.setText(df.format(GioHangGT.tongTienGH()) + "₫");
            tongTienTT.setText(df.format(GioHangGT.tienThanhToan()) + "₫");
            imgHinh.setImage(GImage.read("khachhangIMG/", "macdinh.png"));
            f = new File("khachhangIMG/", "macdinh.png");
        }
    }//GEN-LAST:event_txtSDTKeyReleased
    public float checkVIP(Float n) {
        if (n < 5000000) {
            return (float) 0.0;
        } else if (n >= 5000000 && n < 10000000) {
            return (float) 0.05;
        } else if (n >= 10000000 && n < 20000000) {
            return (float) 0.1;
        } else if (n >= 20000000 && n < 50000000) {
            return (float) 0.15;
        } else {
            return (float) 0.2;
        }
    }
    private void imgHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgHinhMouseClicked
        GymSysJFrame.trangThai = "HDGT";
        if (txtSDT.getText().equals("")) {
            MsgBox.alert(HoaDonGoiTapJDailog.this, "Lỗi", "Bạn chưa nhập đầy đủ thông tin", Alert.AlertType.ERROR);
        } else {
            Boolean n = MsgBox.confirm(this, "Khách hàng đã có ảnh chưa ?");
            if (!n) {
                GymSysJFrame.maKH = txtSDT.getText();
                TakePicture t = new TakePicture(gioHangGTPanel);
                t.start();
                this.hide();

            } else {
                int result = jf.showOpenDialog(null);
                data = null;
                if (result == jf.APPROVE_OPTION) {
                    f = jf.getSelectedFile();
                    GImage.save("khachhangIMG/", f);
                    imgHinh.setImage(GImage.read("khachhangIMG/", f.getName()));
                }
            }
        }

    }//GEN-LAST:event_imgHinhMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (check()) {

            if (GioHangGT.tienThanhToan() == 0) {
                MsgBox.alert(null, "Giỏ hàng gói tập trống", "Vui lòng chọn gói tập", Alert.AlertType.ERROR);
            } else {
                String qrcode = "";
                HoiVien hv = hvdao.selectBySDT(txtSDT.getText().trim());

                if (hv != null) {
                    if (hv.getQrCode() == null) {
                        qrcode = GImage.createQRCode(txtSDT.getText().trim(), f, txtEmail.getText().trim());
                    } else {
                        qrcode = hv.getQrCode();
                    }
                } else {
                    qrcode = GImage.createQRCode(txtSDT.getText().trim(), f, txtEmail.getText().trim());
                }

                if (MsgBox.confirm(null, "Khách hàng có muốn xuất hóa đơn không?")) {

                    new HoaDonCTDAO().themHoaDonGoiTap(txtSDT.getText(), Auth.user.getMaNV(),
                            null, txtHoVaTen.getText(),
                            txtDiaChi.getText(), GDate.toDate(txtNgaySinh.getText(), "dd/MM/yyyy"), rdoNam.isSelected() ? 1 : 0, f.getName() + ".png", txtEmail.getText(), qrcode);
                    for (GoiTap gt : GioHangGT.listGT) {
                        new HoaDonCTDAO().themHDCTGoiTap(gt.getMaGT(), txtSDT.getText(), gt.getGia());
                    }
                    BillGT billgt = new BillGT();
                    billgt.printBill(txtSDT.getText(), Auth.user.getMaNV());
                    GioHangGT.clearGT();
                    this.dispose();
                    clone.clear();
                    GymSysJFrame.maKH = "";
                } else {
                    new HoaDonCTDAO().themHoaDonGoiTap(txtSDT.getText(), Auth.user.getMaNV(),
                            null, txtHoVaTen.getText(),
                            txtDiaChi.getText(), GDate.toDate(txtNgaySinh.getText(), "dd/MM/yyyy"), rdoNam.isSelected() ? 1 : 0, f.getName(), txtEmail.getText(), qrcode);
                    for (GoiTap gt : GioHangGT.listGT) {
                        new HoaDonCTDAO().themHDCTGoiTap(gt.getMaGT(), txtSDT.getText(), gt.getGia());
                    }
                    MsgBox.alert(this, "Thông báo", "Mua gói tập thành công", Alert.AlertType.SUCCESS);
                    GioHangGT.clearGT();
                    gioHangGTPanel.setSLGoiTap();
                    this.dispose();
                    clone.clear();
                    GymSysJFrame.maKH = "";

                }
            }

        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtHoVaTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoVaTenKeyReleased
        clone.set(0, txtHoVaTen.getText());
    }//GEN-LAST:event_txtHoVaTenKeyReleased

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        clone.set(1, "nam");
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        clone.set(1, "nu");
    }//GEN-LAST:event_rdoNuActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        clone.set(3, txtEmail.getText());
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtNgaySinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgaySinhKeyReleased
        clone.set(2, txtNgaySinh.getText());
    }//GEN-LAST:event_txtNgaySinhKeyReleased

    private void rdoTienMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTienMatActionPerformed
        clone.set(5, "true");
    }//GEN-LAST:event_rdoTienMatActionPerformed

    private void txtDiaChiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChiKeyReleased
        clone.set(4, txtDiaChi.getText());
    }//GEN-LAST:event_txtDiaChiKeyReleased

    private void rdoTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTheActionPerformed
        clone.set(5, "false");
    }//GEN-LAST:event_rdoTheActionPerformed

    private void txtGhiChuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGhiChuKeyReleased
        clone.set(6, txtGhiChu.getText());
    }//GEN-LAST:event_txtGhiChuKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.Button btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.group2.swing.ConBtn conBtn2;
    private javax.swing.JLabel giamGia;
    private com.group2.swing.GradientBackGround gradientBackGround1;
    private com.group2.swing.GradientBackGround gradientBackGround2;
    private com.group2.swing.GradientBackGround gradientBackGround3;
    private com.group2.swing.ImageView imgHinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel listItemGT;
    private com.group2.swing.RadioButtonCustom rdoNam;
    private com.group2.swing.RadioButtonCustom rdoNu;
    private com.group2.swing.RadioButtonCustom rdoThe;
    private com.group2.swing.RadioButtonCustom rdoTienMat;
    private com.group2.swing.TextAreaScroll textAreaScroll1;
    private com.group2.swing.TextAreaScroll textAreaScroll2;
    private javax.swing.JLabel tongTienTT;
    private com.group2.swing.TextArea txtDiaChi;
    private com.group2.swing.TextField txtEmail;
    private com.group2.swing.TextArea txtGhiChu;
    private com.group2.swing.TextField txtHoVaTen;
    private com.group2.swing.TextField txtNgaySinh;
    private com.group2.swing.TextField txtSDT;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void fillGTToPanel() {
        listItemGT.removeAll();

        for (GoiTap goiTap : GioHangGT.listGT) {
            listItemGT.add(new ItemCartGTPanel(goiTap, listItemGT, gioHangGTPanel, txtTongTien, tongTienTT));
        }

    }

    private void designPanel() {
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setHorizontalScrollBar(new ScrollBarCustom());
    }
    HoiVienDAO hvdao = new HoiVienDAO();

}
