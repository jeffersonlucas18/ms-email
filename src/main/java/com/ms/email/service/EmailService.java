package com.ms.email.service;

import com.ms.email.model.Email;
import com.ms.email.model.dto.EmailDto;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class EmailService {

   private final EmailRepository emailRepository;

   public EmailService(EmailRepository emailRepository){
       this.emailRepository = emailRepository;
   }

    public Email sendingEmail(EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);

        return null;
   }
}
