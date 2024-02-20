package com.green.Finemovie.domain.dto.notice;

import com.green.Finemovie.domain.entity.notice.NoticeEntity;
import com.green.Finemovie.domain.entity.notice.NoticeRepository;

public class NoticeSaveDTO {
	
	private String title;
	private String content;
	
	public NoticeEntity toEntity(NoticeRepository noticeRepository) {
		
		return NoticeEntity.builder()
				.title(title).content(content)
				.build();
		
	}

}
