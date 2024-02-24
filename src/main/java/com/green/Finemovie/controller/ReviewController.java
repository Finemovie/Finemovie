package com.green.Finemovie.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.Finemovie.domain.dto.HomeReviewDTO;
import com.green.Finemovie.service.ReviewService;
import com.green.Finemovie.utils.AuthenUtils;

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
	
	@GetMapping("/reviewManage")
	public String reviewManage() {
		// You might want to add logic to check if the user is authenticated and authorized to access the admin page
		return "review/admin/reviewAdmin"; // Path to your review management page
	}

	
	 @GetMapping("/homeReviewWrite")
	    public String homeReviewWrite() {
	        return "review/admin/homeReviewWrite"; // Assuming homeReviewWrite.html is under src/main/resources/templates
	    }
	
	 
	 @PostMapping("/homeReviewWrite")
	    public ResponseEntity<?> submitReview(@RequestBody HomeReviewDTO homeReviewDTO) {
	        reviewService.addReview(homeReviewDTO);
	        return ResponseEntity.ok().build();
	    }

	    @GetMapping("/homeReviewList")
	    public ResponseEntity<List<HomeReviewDTO>> getAllReviews() {
	        List<HomeReviewDTO> reviews = reviewService.getAllReviews();
	        return ResponseEntity.ok(reviews);
	    }
	
}