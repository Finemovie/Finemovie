package com.green.Finemovie.service;

import org.springframework.ui.Model;

import com.green.Finemovie.domain.dto.MovieIntroDTO;
import com.green.Finemovie.domain.dto.PageRequestDTO;
import com.green.Finemovie.domain.dto.PageResultDTO;
import com.green.Finemovie.domain.entity.MovieIntroEntity;

public interface MovieIntroService {

	void save(MovieIntroDTO mDTO);

	PageResultDTO<MovieIntroDTO, MovieIntroEntity> getList(PageRequestDTO mDTO);

	void movieIntroDetail(Long no, Model model);

	MovieIntroEntity getNo(Long no);

	void edit(long no, MovieIntroDTO mDTO);

	void deleteMovieIntro(long no);

}
