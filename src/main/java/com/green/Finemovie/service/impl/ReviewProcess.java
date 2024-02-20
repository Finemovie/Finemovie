package com.green.Finemovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.green.Finemovie.domain.dto.ReviewDTO;
import com.green.Finemovie.mybatis.mapper.ReviewMapper;
import com.green.Finemovie.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import templates.utils.PageData;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReviewProcess implements ReviewService {
	
	private final ReviewMapper reviewMapper;
	
	@Override
	public List<ReviewDTO> listProcess(int page, String search) {
		
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
		

		List<ReviewDTO> reviewList = reviewMapper.findAll(search, offset, limit);

		PageData pageData = PageData.create(page, limit, rowCount);

		return reviewList;
		
	}
	
	
}
