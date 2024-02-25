package com.green.Finemovie.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewWriteDTO {
	
	private String title;
	private String content;
	private String writer;
	private long no;
	private int grade;
	private LocalDateTime createdAt;
	
}
