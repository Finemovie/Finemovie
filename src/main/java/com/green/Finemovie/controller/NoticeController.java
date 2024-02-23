package com.green.Finemovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.green.Finemovie.domain.dto.notice.NoticeListDTO;
import com.green.Finemovie.domain.dto.notice.NoticeSaveDTO;
import com.green.Finemovie.service.NoticeService;
import com.green.Finemovie.service.NoticeUpdateDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("/notice")
	public String noticelist(Model model) {
		List<NoticeListDTO> noticeList = noticeService.getnoticeList();
		model.addAttribute("noticeList", noticeList); // 변경된 부분
		return "notice/notice";
	}

	@GetMapping("/addnotice")
	public String addnotice() {
		return "notice/addnotice";
	}

	@PostMapping("/addnotice/register")
	public String registernotice(NoticeSaveDTO dto) {
		return noticeService.saveNotice(dto);
	}

	@GetMapping("/noticeedit/{no}")
	public String noticeedit(@PathVariable(name = "no") long no, Model model) {
		noticeService.noticeedit(no, model);
		return "notice/noticeedit";
	}

	@PutMapping("/noticeedit/{no}")
	public String update(@PathVariable(name = "no") long no, NoticeUpdateDTO dto) {
		noticeService.updateProcess(no, dto);
		return "redirect:/noticeedit/" + no;
	}
	
	
}