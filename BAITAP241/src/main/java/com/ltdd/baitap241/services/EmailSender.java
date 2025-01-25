package com.ltdd.baitap241.services;

import com.ltdd.baitap241.entity.EmailDetails;

public interface EmailSender {
    public String sendMail(EmailDetails details);
}
