package com.green.Finemovie.domain.dto.notice;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NoticeListDTO {

	private Long id;

	private String title;
	private String content;

	private LocalDateTime createdAt;
}