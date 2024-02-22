package com.green.Finemovie.domain.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class MemberDetails extends User {

	private static final long serialVersionUID = 1L;
	
	private Integer memNo;
	private String memName;
	private String memRole;
	
	public MemberDetails(String memUsername, String memPassword, Collection<? extends GrantedAuthority> authorities) {
		super(memUsername, memPassword, authorities);
	}

	public MemberDetails(MemberEntity memberEntity) {
		this(memberEntity.getMemUsername(), memberEntity.getMemPassword(), memberEntity.getMyRoles().stream()
				.map(memRole -> new SimpleGrantedAuthority(memRole.name()))
				.collect(Collectors.toSet()));

		this.memNo = memberEntity.getMemNo();
		this.memName = memberEntity.getMemName();
		this.memRole = memberEntity.getMemRole();
	}

}