package com.green.Finemovie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.Finemovie.domain.dto.ReviewDTO;
import com.green.Finemovie.mybatis.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReviewController {
	
	
	private final ReviewMapper reviewMapper;
	
	@GetMapping("/reviewHome")
	public String reviewHome() {
		
		return "review/reviewHome";
	}
	
	 @GetMapping("/reviewBoard")
	    public String reviewBoard() {
	        return "review/reviewBoard"; 
	    } 

	 @GetMapping("/reviewBoardData") // Data-fetching endpoint
	 @ResponseBody 
	 public List<ReviewDTO> getReviewBoardData() {
		 
	      return reviewMapper.findAll();
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