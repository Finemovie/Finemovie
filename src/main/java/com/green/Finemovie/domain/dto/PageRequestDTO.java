package com.green.Finemovie.domain.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PageRequestDTO {
	
	private int page;
	private int size;
	
	
	public PageRequestDTO() {
		this.page=1;
		this.size=6;
	}
	
	
	public Pageable getPageable(Sort sort) {
		
		return PageRequest.of(page -1, size, sort);
		
	}
	
	public Pageable getPageable(int size ,Sort sort) {
		
		return PageRequest.of(page -1, size, sort);
		
	}
}
