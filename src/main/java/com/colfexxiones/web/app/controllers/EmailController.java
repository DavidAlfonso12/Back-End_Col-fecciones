package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.DTO.EmailDTO;
import com.colfexxiones.web.app.repository.EmailRepository;
import com.colfexxiones.web.app.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(path = "api/v1/emailPassword")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping
    private ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) throws MessagingException {
        emailService.sendEmail(emailDTO);
        return new ResponseEntity<>("Correo Enviado con exito", HttpStatus.OK);
    }
}
