package com.green.Finemovie.service;

import com.green.Finemovie.domain.dto.MemberDTO;

public interface MemberService {
	
	void memRegistration(MemberDTO memberDTO);
	

	boolean existsByempUsername(String empUsername);
	
	void employeeUpdate(MemberDTO memberDTO);


	
}