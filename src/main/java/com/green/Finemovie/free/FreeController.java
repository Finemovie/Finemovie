package com.green.Finemovie.free;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FreeController {
	
	//자유게시글 등록 페이지 이동
	@GetMapping("/freeAdd")
	public String freeAdd() {
		return "/free/freeAdd";
	}
	
	//자유게시글 리스트 페이지 이동
	@GetMapping("/freeList")
	public String freeList() {
		return "/free/freeList";
	}
	
	//자유게시글 리스트 페이지 이동
	@GetMapping("/freeDetail")
	public String freeDetail() {
		return "/free/freeDetail";
	}

	
	// 자유게시글 상세 정보 조회 및 처리
    @GetMapping("/freeDetail/{id}")
    public String getFreeDetail(@PathVariable Long id, Model model) {
    // 상세 정보 조회 로직
    // FreeEntity freeEntity = freeService.getFreeEntityById(id);
    // model.addAttribute("freeEntity", freeEntity);
    return "free/freeDetail";
    }
	
}
