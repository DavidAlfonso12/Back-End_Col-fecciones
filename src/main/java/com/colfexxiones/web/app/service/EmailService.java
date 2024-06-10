package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.DTO.EmailDTO;
import com.colfexxiones.web.app.entity.Usuario;
import com.colfexxiones.web.app.repository.EmailRepository;
import com.colfexxiones.web.app.repository.UsuarioRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Optional;

@Service
public class EmailService implements EmailRepository {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    UsuarioRepository usuarioRepository;

    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) throws MessagingException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(emailDTO.getDestinatario());
        if(usuario.isPresent()){
            try {
                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
                helper.setTo(emailDTO.getDestinatario());
                helper.setSubject(emailDTO.getAsunto());
                String password = usuario.get().getUsuario_password();
                String passwordEnviar = "";
                int mitadPassword = password.length() / 2 - 1;
                for (int i = 0; i <= password.length()-1; i++){
                    if(i <= mitadPassword){
                        passwordEnviar += password.charAt(i);
                    }else {
                        passwordEnviar += "*";

                    }
                }
                Context context = new Context();
                context.setVariable("mensaje", emailDTO.getMensaje() + passwordEnviar);
                String contentHTML = templateEngine.process("email", context);

                helper.setText(contentHTML, true);
                javaMailSender.send(message);
            }catch (Exception e){
                throw new RuntimeException("Error" + "Al enviar el correo" + e.getMessage(), e);
            }
        }else{
            throw new RuntimeException("Error" + "El correo no se encuentra registrado");
        }

    }
}
