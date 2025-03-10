package com.example.user.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailUtil {

    @Value("${spring.mail.smtp.email}")
    private String email;
    @Value("${spring.mail.smtp.password}")
    private String password;
    @Value("${spring.mail.smtp.host}")
    private String host;
    @Value("${spring.mail.smtp.port}")
    private String port;
    @Value("${spring.mail.smtp.auth}")
    private String auth;
    @Value("${spring.mail.smtp.starttls.enable}")
    private String starttls;

    // 发送邮件
    public  void sendEmail(String toEmail, String text, String subject) {

        // 邮件服务器配置
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host); // 邮件服务器地址
        properties.put("mail.smtp.port", port); // 邮件服务器端口
        properties.put("mail.smtp.auth", auth);
        properties.put("mail.smtp.starttls.enable", starttls);

        // 创建会话
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            // 创建邮件
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setText(text);

            // 发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败！");
        }
    }
}
