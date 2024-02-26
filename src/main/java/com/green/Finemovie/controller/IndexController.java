package com.green.Finemovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.Finemovie.domain.dto.PageRequestDTO;
import com.green.Finemovie.domain.dto.ReviewDTO;
import com.green.Finemovie.domain.dto.notice.NoticeListDTO;
import com.green.Finemovie.service.MovieIntroService;
import com.green.Finemovie.service.NoticeService;
import com.green.Finemovie.service.ReviewService;

@Controller
public class IndexController {

	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/")
	public String noticelist(Authentication auth,Model model,
			 @RequestParam(name = "page", defaultValue = "1") int page,
			 @RequestParam(name = "search", required = false) String search) {
		List<NoticeListDTO> noticeList = noticeService.getnoticeList();
		model.addAttribute("noticeList", noticeList); // 변경된 부분
		
		
		return "index";
	}
	
	

}
