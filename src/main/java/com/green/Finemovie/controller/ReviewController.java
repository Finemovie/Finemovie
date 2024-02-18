package com.green.Finemovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {
	
	@GetMapping("/reviewHome")
	public String reviewHome() {
		
		return "review/reviewHome";
	}
	
	
	@GetMapping("/reviewBoard")
	public String reviewBoard(){
		
		return "review/reviewBoard";
	}
	
	@GetMapping("/reviewPro")
	public String reviewPro() {
		
		return "review/reviewPro";
		
	}
	
	
	@GetMapping("/reviewLike")
	public String reviewLike() {
		
		return "review/reviewLike";
	}
	
}