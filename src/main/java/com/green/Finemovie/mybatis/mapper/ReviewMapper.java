package com.green.Finemovie.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.Finemovie.domain.dto.ReviewDTO;



@Mapper
public interface ReviewMapper {

	//mapper에 접속하는 DAO (data access object) 라고 보면 된다.
	
	void save(ReviewDTO reviewDTO);
	
	List<ReviewDTO> findAll();
	
	

}
