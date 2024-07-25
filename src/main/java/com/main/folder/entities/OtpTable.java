package com.main.folder.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "otptable")
public class OtpTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int otpId;
	@Column(name = "username" )
	private String userName;
	@Column(name = "otp")
	private int otpValue;
	@Column(name = "createdon")
	private Date createOn;

	public OtpTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OtpTable(String userName, int otpValue, Date createOn){
		this.userName = userName;
		this.otpValue = otpValue;
		this.createOn = createOn;
	}

	public int getotpId() {
		return otpId;
	}

	public void setotpId(int otpId) {
		this.otpId = otpId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getotpValue() {
		return otpValue;
	}

	public void setotpValue(int otpValue) {
		this.otpValue = otpValue;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	
	
	
}
