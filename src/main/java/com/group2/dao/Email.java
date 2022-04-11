/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.dao;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author LONG
 */
public class Email {

    public static void sendEmail(String to, String subject, String BBC, String message, File file) {
        
            Properties p = new Properties();

            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            p.put("mail.debug", "true");

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("longtimenoseemeem@gmail.com","Hung@123");
                }
            };
            Session session = Session.getInstance(p, auth);
            try {
            Message msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("Hi","NoReply"));
            msg.setSubject(subject);

            InternetAddress[] id = InternetAddress.parse(BBC);
            if (!BBC.equals("")) {
                msg.setRecipients(Message.RecipientType.BCC, id);
            }
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setText(message);

            if (file.length() != 0) {
                msg.setDataHandler(new DataHandler(new FileDataSource(file.getAbsoluteFile())));
            }
            Transport.send(msg);

        } catch (Exception e) {
            System.out.println("sendmail: " + e.getMessage());
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Email.sendEmail("truonghoanglong1308@gmail.com", "test", "longthps16784@fpt.edu.vn",
                "hihi", new File("null"));
    }
}
