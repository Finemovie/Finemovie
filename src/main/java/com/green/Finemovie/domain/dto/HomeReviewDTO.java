package com.green.Finemovie.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeReviewDTO {
	
	private String name;
	private int rating;
	private String director;
	private String text;
	private String imageUrl;
	
}
