package com.green.Finemovie.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class NoticeUpdateDTO {
	private long id;
	private String title;
	private String content;
}
