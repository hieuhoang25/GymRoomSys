package com.group2.utils;

import com.group2.swing.GioHangGTPanel;
import com.group2.ui.GymSysJFrame;
import com.group2.ui.HoaDonGoiTapJDailog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class TakePicture extends JFrame {

    private JLabel label;
    private ImageIcon icon;
    private VideoCapture capture;
    private Mat image;
    private boolean clicked = false, closed = false;
    private String maNV;

    public  void start() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TakePicture d = new TakePicture(gioHangGTPanel);
                d. setVisible(true);
                new Thread(new Runnable() {
                    public void run() {
                        d.startCamera();
                    }
                }).start();
            }
        });

    }
    GioHangGTPanel gioHangGTPanel;

    public TakePicture(GioHangGTPanel gioHangGTPanel) {
        this.gioHangGTPanel = gioHangGTPanel;

        setLayout(null);

        label = new JLabel();
        label.setBounds(0, 0, 640, 480);
        add(label);

        JButton btn = new JButton("capture");
        btn.setBounds(300, 480, 80, 40);
        add(btn);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = true;
            }
        });

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                capture.release();
                image.release();
                closed = true;
//                System.out.println("closed");
                setVisible(false);

                if (GymSysJFrame.trangThai.equals("HDGT")) {
                    new HoaDonGoiTapJDailog(gioHangGTPanel).setVisible(true);

                }

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                super.windowDeactivated(e);
//                System.out.println("closed");
            }

        });

        setFocusable(false);
        setSize(640, 560);
        setLocationRelativeTo(null);
        setTitle("Camera");
        setIconImage(new ImageIcon(getClass().getResource("/com/group2/icons/icons8_camera_48px.png")).getImage());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       

    }

    public void startCamera() {
        capture = new VideoCapture(0);
        image = new Mat();
        byte[] imageData;
        while (true) {
            capture.read(image);

            final MatOfByte buf = new MatOfByte();
            Imgcodecs.imencode(".png", image, buf);

            imageData = buf.toArray();
//            System.out.println(icon);
            icon = new ImageIcon(imageData);
            label.setIcon(icon);
            if (clicked) {
                String name = GymSysJFrame.maKH;

                Imgcodecs.imwrite("khachhangIMG/" + name + ".png", image);
                clicked = false;

                if (GymSysJFrame.trangThai.equals("HDGT")) {
                    new HoaDonGoiTapJDailog(gioHangGTPanel).setVisible(true);
                    this.setVisible(false);
                } else {
                    this.setVisible(false);
                }

            }
            if (closed) {
                break;
            }
        }
    }

}
