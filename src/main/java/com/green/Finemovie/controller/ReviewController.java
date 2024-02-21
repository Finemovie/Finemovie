package com.green.Finemovie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.Finemovie.domain.dto.ReviewDTO;
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
	public List<ReviewDTO> reviewBoard(
				@RequestParam(name = "page", defaultValue = "1") int page,
				@RequestParam(name = "search",defaultValue = "",required = false) String search
			) {
		
		reviewService.listProcess(page, search);
        return "review/reviewBoard";  // Create a ResponseEntity
	
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