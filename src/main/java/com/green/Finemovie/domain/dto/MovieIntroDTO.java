package com.green.Finemovie.domain.dto;

import java.time.LocalDateTime;

import com.green.Finemovie.domain.entity.MemberEntity;
import com.green.Finemovie.domain.entity.MovieIntroEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieIntroDTO {

	private Long no;
	private String title;
	private String content;
	private boolean type;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Long readCount;
	private String writer;
	
	public MovieIntroEntity toEntity() {
		return MovieIntroEntity.builder()
				.no(no)
				.writer(writer)
				.title(title)
				.content(content)
				.createdAt(createdAt)
				.updatedAt(updatedAt)
				.type(type)
				.build();
	}
}

