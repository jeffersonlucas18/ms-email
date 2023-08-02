package com.ms.email.service;

import com.ms.email.model.Email;
import com.ms.email.model.dto.EmailDto;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    JavaMailSender javaMailSender;


    public Email sendingEmail(EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        email.setSendDateEmail(new Date());
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(emailDto.getEmailFrom());
            simpleMailMessage.setTo(emailDto.getEmailTo());
            simpleMailMessage.setSubject(emailDto.getSubject());
            simpleMailMessage.setText(emailDto.getText());
            javaMailSender.send(simpleMailMessage);

            email.setStatusId(2l); //ENVIADO
        } catch (Exception exception) {
            exception.printStackTrace();
            email.setStatusId(1l); //ERROR
        } finally {
            return emailRepository.save(email);
        }
    }
}
