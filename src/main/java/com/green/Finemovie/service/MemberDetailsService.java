package com.green.Finemovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.Finemovie.domain.entity.MemberDetails;
import com.green.Finemovie.domain.entity.MemberEntityRepository;

public class MemberDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberEntityRepository memberEntityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String memUsername) throws UsernameNotFoundException {
	
		return new MemberDetails(memberEntityRepository.findByMemUsername(memUsername).orElseThrow());

	}
	
}