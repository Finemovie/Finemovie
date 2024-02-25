package com.green.Finemovie.free;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FreeDTO {
	
	private long freeNo;
	
	private String writer;
	
	private String password;
	
	private String title;
	
	private String content;
	
	private int viewCount;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
	
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = LocalDateTime.of(createdDate, LocalTime.now());
	}
	
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = LocalDateTime.of(updatedDate, LocalTime.now());
	}
	
	public FreeEntity toFreeEntity() {
		return FreeEntity.builder()
				.freeNo(freeNo)
				.writer(writer)
				.password(password)
				.title(title)
				.content(content)
				.viewCount(viewCount)
				.createdDate(createdDate)
				.updatedDate(updatedDate)
				.build();

	}

}
