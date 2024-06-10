package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.DTO.EmailDTO;
import jakarta.mail.MessagingException;

public interface EmailRepository {
    public void sendEmail(EmailDTO emailDTO) throws MessagingException;
}
