package com.sample.AcademicProjectManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendApprovalNotification(String recipientEmail) {
        String subject = "Registration Approval";
        String text = "Congratulations! Your registration has been approved.";

        sendEmail(recipientEmail, subject, text);
    }

    public void sendRejectionNotification(String recipientEmail) {
        String subject = "Registration Rejection";
        String text = "We regret to inform you that your registration has been rejected.";

        sendEmail(recipientEmail, subject, text);
    }

    private void sendEmail(String recipientEmail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
