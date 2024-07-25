package com.main.folder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.main.folder.entities.OtpTable;

public interface OtpRepository extends CrudRepository<OtpTable, Integer> {
	
	@Query(nativeQuery = true, value  = "select otp from otptable where username = ?1")
	public String getOtpByUserName(String userName);
	
	
	@Query(nativeQuery = true, value  = "select top 1 otp , createdon from otptable where username = ?1 order by createdon desc")
	public List<Object> getOtpAndCreatedOnByUserName(String userName);

}
