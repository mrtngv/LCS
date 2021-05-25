package com.logistics.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailFunctions {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailFunctions(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public ResponseEntity<Object> sendEmail(String privateCode, String senderEmail, String receiverEmail) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageBuilder = new MimeMessageHelper(message, true);
        messageBuilder.setFrom("needylogisticcomapny@gmail.com");
        messageBuilder.setTo(senderEmail);
        messageBuilder.setSubject(MailTemplates.senderSubject_mail);
        messageBuilder.setText(MailTemplates.buildSenderMail(senderEmail,privateCode), true);
        javaMailSender.send(message);


        return ResponseEntity.ok(null);


    }

}
