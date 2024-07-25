package com.main.folder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.main.folder.entities.OtpTable;
import com.main.folder.repository.OtpRepository;

@Component
public class OTPService {

	@Autowired
	private  OtpRepository otpRepository;

	public void saveOTP(OtpTable otp) {
		otpRepository.save(otp);
	}
	
	public String getOtp(String userName) {
		String otp = otpRepository.getOtpByUserName(userName);
		return otp;
	}
	
	
	public List<Object> getOtpAndCreatedOn(String userName) {
		return otpRepository.getOtpAndCreatedOnByUserName(userName);
	}

}
