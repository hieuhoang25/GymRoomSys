/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.ui;

import com.group2.dao.CheckInDAO;
import com.group2.dao.HoiVienDAO;
import com.group2.dao.ThongKeDAO;
import com.group2.entity.ChekIn;
import com.group2.entity.HoiVien;
import com.group2.entity.ThongKe;
import com.group2.swing.EventSelected;
import com.group2.utils.Auth;
import com.group2.utils.GDate;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author HieuHoang
 */
public class GymSysJFrame extends javax.swing.JFrame {

    HoiVienDAO hoiVienDAO = new HoiVienDAO();
    List<HoiVien> list;
    CheckInDAO checkInDAO = new CheckInDAO();
    List<ChekIn> listCheckIn = checkInDAO.selectAll();
    ThongKeDAO thongKeDAO = new ThongKeDAO();
    List<ChekIn> listchIn;
    List<ThongKe> listThongKe, listThongKeHVHetHan;
    Integer ID;
    HomeUI h = new HomeUI();
    Auth auth = new Auth();
    public static String trangThai, maKH;

    /**
     * Creates new form GymSysJFrame
     */
    public GymSysJFrame() {
        maKH = "";
        initComponents();
        status1.setListModelCheckIn(homeUI1.getDlmList1(), homeUI1.getCard4());
        checkInDAO.deleteCheckIn(GDate.toDate(java.time.LocalDate.now().toString(), "yyyy-MM-dd"));
        hoiVienDAO.kiemTraHVHetHan();
        setBackground(new Color(0, 0, 0, 0));
        menu2.setMainFrame(GymSysJFrame.this);
        status1.setMainFrame(GymSysJFrame.this);
        status1.addEventSelectedMenuItem(new EventSelected() {
            @Override
            public void selected(int index) {
                System.out.println(index);
                if (index == 2) {
                    GymSysJFrame.this.setVisible(false);
                    new DangNhapJDialog().setVisible(true);
                } else {
                    if (index == 0) {
                        new MyAcountJDailog(Auth.user).setVisible(true);
                    } else {
                        new DoiMatKhauJDailog().setVisible(true);
                    }
                }
            }
        });

        menu2.addEventSelectedMenuItem(new EventSelected() {
            @Override
            public void selected(int index) {
                if (Auth.isManager()) {
                    if (index == 0) {
                        main.removeAll();
                        HomeUI hui = new HomeUI();
                        main.add(hui);
                        status1.setListModelCheckIn(hui.getDlmList1(), hui.getCard4());

                        main.revalidate();
                    } else {
                        if (index == 2) {
                            main.removeAll();
                            main.add(new HoiVienUI());
                            main.revalidate();
                        } else {
                            if (index == 12) {
                                main.removeAll();
                                main.add(new ThongKeUI());
                                main.revalidate();
                            } else {
                                if (index == 10) {
                                    main.removeAll();
                                    main.add(new NhanVienUI());
                                    main.revalidate();
                                } else {
                                    if (index == 4) {
                                        main.removeAll();
                                        main.add(new KhachHangUI());
                                        main.revalidate();
                                    } else {
                                        if (index == 6) {
                                            main.removeAll();
                                            main.add(new QLGoiTapUI());
                                            main.revalidate();
                                        } else {
                                            if (index == 8) {

                                                main.removeAll();
                                                main.add(new QLSanPhamUI());
                                                main.revalidate();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (index == 0) {
                        main.removeAll();
                        HomeUI hui = new HomeUI();
                        main.add(hui);
                        status1.setListModelCheckIn(hui.getDlmList1(), hui.getCard4());

                        main.revalidate();
                    } else {
                        if (index == 2) {
                            main.removeAll();
                            main.add(new HoiVienUI());
                            main.revalidate();
                        } else {
                            if (index == 10) {
                                main.removeAll();
                                main.add(new ThongKeUI());
                                main.revalidate();
                            } else {
                                if (index == 4) {
                                    main.removeAll();
                                    main.add(new KhachHangUI());
                                    main.revalidate();
                                } else {
                                    if (index == 6) {

                                        main.removeAll();
                                        main.add(new GioiTapUI());
                                        main.revalidate();

                                    } else {
                                        if (index == 8) {

                                            main.removeAll();
                                            SanPhamUI ui = new SanPhamUI();
                                            menu2.setPanel(ui.getMain());
                                            main.add(ui);
                                            if (GymSysJFrame.this.getExtendedState() == JFrame.MAXIMIZED_BOTH) {

                                                ui.getMain().setLayout(new MigLayout("wrap 5, insets 5"));

                                            } else {
                                                ui.getMain().setLayout(new MigLayout("wrap 4, insets 20"));
                                            }
                                            main.revalidate();

                                        }
                                    }
                                }
                                {

                                }
                            }
                        }
                    }
                }

            }
        });
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
        menu2 = new com.group2.swing.Menu();
        status1 = new com.group2.swing.Status();
        main = new javax.swing.JPanel();
        homeUI1 = new com.group2.ui.HomeUI();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientBackGround1.setBorderRadius(5);

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setLayout(new java.awt.BorderLayout());
        main.add(homeUI1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout gradientBackGround1Layout = new javax.swing.GroupLayout(gradientBackGround1);
        gradientBackGround1.setLayout(gradientBackGround1Layout);
        gradientBackGround1Layout.setHorizontalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        gradientBackGround1Layout.setVerticalGroup(
            gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBackGround1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(gradientBackGround1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(gradientBackGround1Layout.createSequentialGroup()
                        .addComponent(status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                        .addGap(6, 6, 6))))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GymSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GymSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GymSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GymSysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        ChaoJDialog s = new ChaoJDialog();
        s.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        s.setVisible(false);
        new DangNhapJDialog().setVisible(true);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GymSysJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.group2.swing.GradientBackGround gradientBackGround1;
    private com.group2.ui.HomeUI homeUI1;
    private javax.swing.JPanel main;
    private com.group2.swing.Menu menu2;
    private com.group2.swing.Status status1;
    // End of variables declaration//GEN-END:variables
}
