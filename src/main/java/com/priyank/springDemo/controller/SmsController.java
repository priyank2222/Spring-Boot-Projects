package com.priyank.springDemo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.priyank.springDemo.model.SmsDetails;
import com.priyank.springDemo.service.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/sms")
public class SmsController {

	@Autowired
    private final SmsService smsService;
    
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public String sendSms(@RequestBody SmsDetails smsDetails) {
    	System.out.println("In Send SMS");
        smsService.sendSms(smsDetails);
        return "SMS sent successfully";
    }
}

