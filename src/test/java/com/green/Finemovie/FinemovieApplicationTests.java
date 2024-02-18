package com.green.Finemovie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.Finemovie.domain.dto.ReviewDTO;
import com.green.Finemovie.mybatis.mapper.ReviewMapper;

@SpringBootTest
class FinemovieApplicationTests {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	
	@Test
	void 게시글테스트() {
		
		ReviewDTO dto;
		reviewMapper.save(ReviewDTO.builder()
				.title("테스트")
				.content("내용테스트")
				.writer("작성자1")
				.build());
	}

}
