package com.green.Finemovie.service;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface ReviewService {

	ModelAndView listProcess(int page, String search);

	String getReview(Authentication auth, Model model);

	
	
}
