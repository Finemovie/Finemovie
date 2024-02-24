package com.green.Finemovie.service.impl;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.green.Finemovie.domain.dto.HomeReviewDTO;
import com.green.Finemovie.domain.dto.ReviewDTO;
import com.green.Finemovie.mybatis.mapper.ReviewMapper;
import com.green.Finemovie.service.ReviewService;
import com.green.Finemovie.utils.PageData;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReviewProcess implements ReviewService {
	
	private final ReviewMapper reviewMapper;
	
	@Override
	public ModelAndView listProcess(int page, String search) {
		
		int limit=10;
		int offset=Math.max(0, (page-1)*limit);
		
		int calculatedPage = page-1;
		if(calculatedPage <1) {
			page = 1;
		} else {
			page = calculatedPage;
		}
		
		int rowCount = reviewMapper.countAllSearch(search);
		
		
		if(rowCount <=0) {
			page=1;
			rowCount=0;
		}
		
		page = page + 1;
		
		boolean hasResults = (rowCount >0);
		
		System.out.println(">>>>>>>"+search);
		

		return new ModelAndView("review/reviewBoard")
				.addObject("list",reviewMapper.findAll(search, offset, limit))
				.addObject("pu",PageData.create(page, limit, rowCount, 5))
				.addObject("search",search)
				.addObject("hasResults",hasResults)
				;
		

		
	}

	@Override
	public String getReview(Authentication auth, Model model) {
		
		return null;
	}

	@Override
	public void addReview(HomeReviewDTO homeReviewDTO) {
		reviewMapper.insertReview(homeReviewDTO);
	}

	@Override
	public List<HomeReviewDTO> getAllReviews() {
		
		return reviewMapper.findAllReviews();
	}
	
	
	
	
	
}