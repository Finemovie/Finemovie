package com.green.Finemovie.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.green.Finemovie.domain.dto.HomeReviewDTO;
import com.green.Finemovie.domain.dto.ReviewDTO;



@Mapper
public interface ReviewMapper {

	//mapper에 접속하는 DAO (data access object) 라고 보면 된다.
	
	void save(ReviewDTO reviewDTO);
	
	List<ReviewDTO> findAll(@Param("search") String search, @Param("offset") int offset, @Param("limit") int limit);
	
	int countAllSearch(String search);
	
	@Insert("INSERT INTO home_review(name, rating, director, content, image_url) VALUES(#{name}, #{rating}, #{director}, #{content}, #{imageUrl})")
    void insertReview(HomeReviewDTO homeReviewDTO);

    @Select("SELECT * FROM home_review")
    List<HomeReviewDTO> findAllReviews();

}
