package com.vishnya.services;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {

    void send(SimpleMailMessage message);

}
