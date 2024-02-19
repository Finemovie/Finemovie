package com.green.Finemovie.free;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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


}
