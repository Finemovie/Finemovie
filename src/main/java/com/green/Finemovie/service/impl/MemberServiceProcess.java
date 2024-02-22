package com.green.Finemovie.service.impl;

import java.lang.reflect.Member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.Finemovie.domain.dto.MemberDTO;
import com.green.Finemovie.domain.entity.MemberEntity;
import com.green.Finemovie.domain.entity.MemberEntityRepository;
import com.green.Finemovie.domain.entity.MyRole;
import com.green.Finemovie.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceProcess implements MemberService {

	private final MemberEntityRepository memberEntityRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void memRegistration(MemberDTO memberDTO) {
		MemberEntity employeeEntity = memberEntityRepository
				.save(memberDTO.toEmployeeEntity(passwordEncoder).addRole(MyRole.USER));
		// POST
		// https://workplace.apigw.ntruss.com/organization/apigw/v2/company/{companyId}/employee/{externalKey}

	}

	// empUSername이 존재하는지 찾아 boolean으로 리턴
	@Override
	public boolean existsByempUsername(String empUsername) {
		return memberEntityRepository.existsByEmpUsername(empUsername);
	}

	@Override
	public void employeeUpdate(MemberDTO employeeDTO) {
		// TODO Auto-generated method stub
	}

	public Member getMemberByUsername(String empUsername) {
		// TODO Auto-generated method stub
		return null;
	}

}