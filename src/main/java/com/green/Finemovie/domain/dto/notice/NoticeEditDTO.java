package com.green.Finemovie.domain.dto.notice;

import com.green.Finemovie.domain.entity.notice.NoticeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class NoticeEditDTO {
	
	private Long no;
	private String title;
	private String content;
	
	public NoticeEntity toEntity() {
		return NoticeEntity.builder()
				.no(no)
				.title(title)
				.content(content)
				.build();
	}
}