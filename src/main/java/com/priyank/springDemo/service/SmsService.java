package com.priyank.springDemo.service;

import com.priyank.springDemo.model.SmsDetails;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String fromPhoneNumber;
    
    @PostConstruct
    public void init() {
        // Initialize Twilio
        Twilio.init(accountSid, authToken);
    }
    
    public void sendSms(SmsDetails smsDetails) {
    	
    	System.out.println(accountSid);
    	System.out.println(authToken);
    	System.out.println(fromPhoneNumber);
        Message message = Message.creator(
                new PhoneNumber(smsDetails.getTo()),
                new PhoneNumber(fromPhoneNumber),
                smsDetails.getMessage()
        ).create();

        System.out.println("SMS sent successfully: " + message.getSid());
    }
}

