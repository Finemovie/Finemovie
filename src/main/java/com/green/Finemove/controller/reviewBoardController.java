package com.green.Finemove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class reviewBoardController {
	
	@GetMapping("/reviewBoard")
	public String reviewBoard() {
		
		return "review/reviewBoard";
	}
	
}
