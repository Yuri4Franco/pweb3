package com.example.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;


    public void sendHTML1(String dest, String assunto) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(MimeMessage.RecipientType.TO, dest);
            message.setSubject(assunto);

            String htmlContent = "<h1>Teste de e-mail com HTML </h1>";                   
            message.setContent(htmlContent, "text/html; charset=utf-8");

            mailSender.send(message);

        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
