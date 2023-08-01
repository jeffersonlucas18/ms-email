package com.ms.email.service;

import com.ms.email.model.Email;
import com.ms.email.model.dto.EmailDto;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    private final JavaMailSender javaMailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    public Email sendingEmail(EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailDto.setSendDateEmail(LocalDateTime.now());
        try {
            email.setEmailForm(emailDto.getEmailFrom());
            email.setEmailTo(emailDto.getEmailTo());
            email.setSubject(emailDto.getSubject());
            email.setText(emailDto.getText());
            email.setStatusId(2l); //ENVIADO
        } catch (Exception exception) {
            email.setStatusId(1l); //ERROR
        } finally {
            return emailRepository.save(email);
        }
    }
}
