/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.group2.dao.Email;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */
public class GImage {

    public static Image getAppIcon() {
        URL url = GImage.class.getResource("/com/group2/icons/logo.png");
        return new ImageIcon(url).getImage();
    }

    public static void save(String fd, File src) {
        File dst = new File(fd, src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static ImageIcon read(String fd,String filename) {
        File path = new File(fd, filename);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static byte[] read1(String path) {
        byte[] b = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            int len = fis.available();
            b = new byte[len];
            fis.read(b);
            return b;
        } catch (Exception e) {
            System.out.println("Xfile.read " + e.getMessage());
        }
        return b;
    }

    public static void write(String path, byte[] data, File src) {
        File dst = new File("khachhang", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs(); //Tao thuc muc neu thu muc ko logos ton tai
        }
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            System.out.println("XFile.Write " + e.getMessage());
        }
    }

    public static String createQRCode(String sdt, File src, String email) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix matrix = qrCodeWriter.encode(sdt, BarcodeFormat.QR_CODE, 200, 200);
            File dst = new File("qrcode", src.getName());
            if (!dst.getParentFile().exists()) {
                dst.getParentFile().mkdirs();
            }
            try {
                Path from = Paths.get(src.getAbsolutePath());
                Path to = Paths.get(dst.getAbsolutePath());
                Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
                
            }
            Path path = FileSystems.getDefault().getPath(dst.getPath());
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
            Email.sendEmail(email, "Ma QR HV "+sdt , "",
                "Hãy dùng mã qr của mình để checkin khi vào phòng tập hihi! :))", dst);
            return dst.getName();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
