package com.main.folder.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.folder.dao.SmsRequest;
import com.main.folder.entities.OtpTable;
import com.main.folder.service.OTPService;
import com.main.folder.service.SmsService;

@RestController
public class SmsController {
	@Autowired
	private SmsService smsService;
	
	@Autowired
	OTPService otpService;
	

	@PostMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestBody SmsRequest smsRequest) {

		Integer otp =Integer.valueOf( String.valueOf((int)(Math.random() * 90000000) + 10000000).substring(0,6));
		OtpTable onetp = null;
		
		if (smsRequest == null || smsRequest.getPhoneNumber() == null || smsRequest.getMessage() == null) {
			return ResponseEntity.badRequest().body("Invalid request data");
		} else {
			//smsService.sendSms(smsRequest.getPhoneNumber(), otp);
		    onetp = new OtpTable(smsRequest.getPhoneNumber(), otp, new Date());
           otpService.saveOTP(onetp);
            
		}

		return ResponseEntity.status(HttpStatus.CREATED).body("OTP sent successfully: " + otp);
	}
	
	@GetMapping("/getOtp")
	public ResponseEntity<String> getOtp(@RequestBody SmsRequest smsRequest) {
		String otp = otpService.getOtp(smsRequest.getPhoneNumber());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("your otp is :"+ otp);
	}
	
	@GetMapping("/createdOn")
	public ResponseEntity<List<Object>> getOtpByCretedOn(@RequestBody SmsRequest smsRequest) {
		List<Object> otp = otpService.getOtpAndCreatedOn(smsRequest.getPhoneNumber());
		return new ResponseEntity<List<Object>>(otp, HttpStatus.OK);
	}
}
