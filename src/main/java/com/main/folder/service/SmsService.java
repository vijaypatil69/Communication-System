package com.main.folder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.folder.cfg.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {

//	@Autowired
//	TwilioConfiguration cfg;
//
//	public void sendSms(String toPhoneNumber, String otp) {
//		 String msg = "Your OTP is: "+otp;
//		Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(cfg.twilioPhoneNumber()), msg).create();
//	}

}
