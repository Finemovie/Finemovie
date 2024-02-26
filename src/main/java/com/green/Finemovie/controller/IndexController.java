package com.green.Finemovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.Finemovie.domain.dto.PageRequestDTO;
import com.green.Finemovie.domain.dto.notice.NoticeListDTO;
import com.green.Finemovie.service.MovieIntroService;
import com.green.Finemovie.service.NoticeService;

@Controller
public class IndexController {

	
	@Autowired
	private NoticeService noticeService;

	@GetMapping("/")
	public String noticelist(Model model) {
		List<NoticeListDTO> noticeList = noticeService.getnoticeList();
		model.addAttribute("noticeList", noticeList); // 변경된 부분
		return "index";
	}

}
