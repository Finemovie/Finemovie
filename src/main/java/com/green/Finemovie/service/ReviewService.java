package com.green.Finemovie.service;

import java.util.List;

import com.green.Finemovie.domain.dto.ReviewDTO;

public interface ReviewService {

	List<ReviewDTO> listProcess(int page, String search);

	
	
}
