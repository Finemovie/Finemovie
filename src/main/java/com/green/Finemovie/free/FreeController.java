package com.green.Finemovie.free;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FreeController {
	
	@Autowired
	private FreeService freeService;
	
	//게시글 등록 페이지 이동
	@GetMapping("/freeAdd")
	public String freeAdd() {
		return "/free/freeAdd";
	}
	
	//게시글 등록하기
	@PostMapping("/freeAdd")
	public String freeAdd(FreeDTO dto) throws Exception {
		freeService.saveFree(dto);
		return "redirect:/freeList";
	}
	
	//자유게시글 리스트 페이지 이동
	@GetMapping("/freeList")
	public String freeList(@RequestParam(name="page",defaultValue = "1") int page, 
						   @RequestParam(name = "search", required = false) String keyword,
						   Model model) {
		
		// 게시글 목록 조회
		freeService.listFree(page, model, keyword);
		
		// 검색어를 모델에 추가
		model.addAttribute("keyword", keyword);
		
		return "/free/freeList";
	}
	
	//디테일 페이지 이동
	@GetMapping("/freeDetails/{freeNo}")
	public String freeDetails(@PathVariable("freeNo") long freeNo, Model model) {
	    FreeEntity freeEntity = freeService.getFreeById(freeNo);
	    model.addAttribute("freeDetails", freeEntity);
	    return "/free/freeDetails";
	}
	
	
	
}
