package com.green.Finemovie.free;

import java.time.LocalDateTime;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FreeDTO {
	
private long freeNo;
	
	private String writer;
	
	private String password;
	
	private String title;
	
	private String content;
	
	private int viewCount;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
	
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

	/*public FreeEntity toFreeEntity(PasswordEncoder passwordEncoder) {
		return FreeEntity.builder()
				.freeNo(freeNo)
				.writer(writer)
				.password(passwordEncoder.encode(password))
				.title(title)
				.content(content)
				.viewCount(viewCount)
				.createdDate(createdDate)
				.updatedDate(updatedDate)
				.build();*/
	}

}
