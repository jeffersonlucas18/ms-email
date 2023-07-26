package com.ms.email.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "emails")
public class Email {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "referencia")
    private String ownerRef;

    @Column(name = "para")
    private String emailForm;

    @Column(name = "de")
    private String emailTo;

    @Column(name = "assunto")
    private String subject;

    @Column(name = "texto")
    private String text;

    @Column(name = "data_enviada")
    private Date sendDateEmail;
}
