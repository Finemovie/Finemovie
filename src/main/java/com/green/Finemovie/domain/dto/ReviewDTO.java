package com.green.Finemovie.domain.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public class ReviewDTO {

	private long no;
	private String title;
	private String content;
	private String writer;
	private int count;
	private int grade;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}
