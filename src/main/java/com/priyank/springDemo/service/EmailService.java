package com.priyank.springDemo.service;

import com.priyank.springDemo.model.EmailDetails;

//Interface
public interface EmailService {

 // To send a simple email
 String sendSimpleMail(EmailDetails details);

 // To send an email with attachment
 String sendMailWithAttachment(EmailDetails details);
 
}
