package com.green.Finemovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.Finemovie.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice")
	public String noticelist() {
		
		return "/notice/notice";
	}
	
	@GetMapping("/addnotice")
	public String addnotice() {
		
		return "notice/addnotice";
	}
	
}
