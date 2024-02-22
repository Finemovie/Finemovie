package com.green.Finemovie.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.green.Finemovie.service.MemberDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(13);
	}
	
	@Bean
	UserDetailsService empDetailsService() {
		return new MemberDetailsService();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf((csrf) -> csrf.disable())

		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/css/**", "/img/**", "/js/**","/sign/signup","/favicon.ico","/error").permitAll()
				//.requestMatchers("/mem/**").hasRole("USER") //글쓰기에 필요한 권한설정 ->url설계를 몰라서 주석처리
				.requestMatchers("/admin/**").authenticated()
				.anyRequest().permitAll())
		
		.formLogin(formLogin -> formLogin
				.loginPage("/sign")
				.loginProcessingUrl("/sign/signin")
				.usernameParameter("memUsername")
				.passwordParameter("memPassword")
				.defaultSuccessUrl("/")
				.permitAll())
		
		.logout(logout -> logout
				.logoutSuccessUrl("/sign")
				.invalidateHttpSession(true))
		
		;
		
		return http.build();
	}
}