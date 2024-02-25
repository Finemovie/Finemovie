package com.green.Finemovie.service.impl;

import java.util.Optional;
import java.util.function.Function;

import org.apache.ibatis.datasource.DataSourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.Finemovie.domain.dto.MovieIntroDTO;
import com.green.Finemovie.domain.dto.PageRequestDTO;
import com.green.Finemovie.domain.dto.PageResultDTO;
import com.green.Finemovie.domain.entity.MovieIntroEntity;
import com.green.Finemovie.domain.entity.MovieIntroEntityRepository;
import com.green.Finemovie.service.MovieIntroService;

@Service
public class MovieIntroServiceProcess implements MovieIntroService{

	@Autowired
	MovieIntroEntityRepository movieRepo;
	
	@Override
	public void save(MovieIntroDTO mDTO) {
		movieRepo.save(mDTO.toEntity());
	}

	@Override
	public PageResultDTO<MovieIntroDTO, MovieIntroEntity> getList(PageRequestDTO mDTO) {
		Pageable pageAble = mDTO.getPageable(10,Sort.by("no").descending());
		Page<MovieIntroEntity> result = movieRepo.findAll(pageAble);
		Function<MovieIntroEntity, MovieIntroDTO> fn = entity -> entity.toDTO();
		return new PageResultDTO<>(result, fn);
	}

	@Override
	public void movieIntroDetail(Long no, Model model) {
		model.addAttribute("detail", movieRepo.findById(no)
				.map(MovieIntroEntity::toDTO)
				.orElseThrow()
				);
	}

	@Override
	public MovieIntroEntity getNo(Long no) {
		Optional<MovieIntroEntity> movie = this.movieRepo.findById(no);
		if(movie.isPresent()) {
			MovieIntroEntity mEntity = movie.get();
			mEntity.setReadCount(mEntity.getReadCount()+1);
			this.movieRepo.save(mEntity);
			return mEntity;
		}else {
			throw new DataSourceException("question not found");
		}
	}

	@Override
	public void edit(long no, MovieIntroDTO mDTO) {
		MovieIntroEntity mEntity = movieRepo.findById(no).orElseThrow();
		
		mEntity.setTitle(mDTO.getTitle());
		mEntity.setContent(mDTO.getContent());
		mEntity.setWriter(mDTO.getWriter());
		mEntity.setType(mDTO.isType());
		
		movieRepo.save(mEntity);
	}

	@Override
	public void deleteMovieIntro(long no) {
		MovieIntroEntity eEntity = movieRepo.findById(no).orElseThrow();
		movieRepo.delete(eEntity);
	}

}
