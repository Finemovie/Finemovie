package com.green.Finemovie.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.green.Finemovie.domain.dto.HomeReviewDTO;
import com.green.Finemovie.domain.dto.ReviewWriteDTO;

public interface ReviewService {

	ModelAndView listProcess(int page, String search);

	String getReview(Authentication auth, Model model);

	void addReview(HomeReviewDTO homeReviewDTO);

	List<HomeReviewDTO> getAllReviews();

	String SaveReview(Authentication auth, ReviewWriteDTO dto);

	
	
}
