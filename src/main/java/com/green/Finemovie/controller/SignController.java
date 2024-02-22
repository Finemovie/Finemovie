package com.green.Finemovie.controller;

import java.lang.reflect.Member;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.Finemovie.domain.dto.MemberDTO;
import com.green.Finemovie.service.impl.MemberServiceProcess;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignController {

	private final MemberServiceProcess memberServiceProcess;

	@GetMapping("/sign")
	public String signIn(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "exception", required = false) String exception, Model model) {

		model.addAttribute("error", error);
		model.addAttribute("exception", exception);

		return "sign/sign";
	}

	// 회원가입 페이지로 이동
	@GetMapping("/signup")
	public String signup() {
		return "/sign/signup";
	}

	// 회원가입 저장
	@PostMapping("/sign/signup")
	public String memberRegistration(MemberDTO memberDTO) {
		memberServiceProcess.memRegistration(memberDTO);

		return "redirect:/sign";
	}

	@ResponseBody
	public boolean checkMemUsername(@RequestParam(value = "memUsername") String memUsername) {
		return memberServiceProcess.existsByempUsername(memUsername);
	}

	@GetMapping("/mypage")
	public String myPage(Model model, Principal principal) {
		//현재 로그인한 사용자의 아이디를 가져온다.
		String memUsername=principal.getName();
        Member member = memberServiceProcess.getMemberByUsername(memUsername);

		//아이디를 기반으로 회원정보를 조회한다.
        model.addAttribute("memUsername", memUsername);
		return "/sign/mypage";
	}

	


}
