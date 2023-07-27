package com.ms.email.rest;

import com.ms.email.model.Email;
import com.ms.email.model.dto.EmailDto;
import com.ms.email.repository.EmailRepository;
import com.ms.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailRestController {

    private final EmailService emailService;

    public EmailRestController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/sending-email.json")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(emailService.sendingEmail(emailDto));
    }
}
