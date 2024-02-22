package com.green.Finemovie.domain.dto;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.Finemovie.domain.entity.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	
	private long memNo;
	private String memUsername;
	private String memPassword;
	private String memName;
	private String memRole;
	private BigInteger memPhone;
	private Date memBirth;
	
	
	public MemberEntity toEmployeeEntity(PasswordEncoder passwordEncoder) {
		return MemberEntity.builder()
				.memUsername(memUsername)
				.memPassword(passwordEncoder.encode(memPassword))
				.memName(memName)
				.memRole(memRole)
				.memBirth(memBirth)
				.memPhone(memPhone)
				.build();
	}
}