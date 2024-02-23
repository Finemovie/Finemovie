package com.green.Finemovie.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.Finemovie.service.ReviewService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Controller
public class ReviewController {
	
	
	private final ReviewService reviewService;
	
	@GetMapping("/reviewHome")
	public String reviewHome() {
		
		return "review/reviewHome";
	}
	


	
	@GetMapping("/reviewBoard")
	public ModelAndView reviewBoard(
				@RequestParam(name = "page", defaultValue = "1") int page,
				@RequestParam(name = "search",defaultValue = "",required = false) String search
			
			) {

        return reviewService.listProcess(page, search);  // Create a ResponseEntity

	}
	
	@GetMapping("/reviewWrite")
	public String reviewWrite(Authentication auth, Model model) {
		return reviewService.getReview(auth, model);
		
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