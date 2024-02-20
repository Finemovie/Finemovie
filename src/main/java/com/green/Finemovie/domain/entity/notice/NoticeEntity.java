package com.green.Finemovie.domain.entity.notice;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.green.Finemovie.domain.dto.notice.NoticeListDTO;
import com.green.Finemovie.service.NoticeUpdateDTO;
import com.green.Finemovie.domain.dto.notice.NoticeEditDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Notice")
public class NoticeEntity {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    private String title;
    private String content;
    
    @CreationTimestamp
    @Column(columnDefinition = "timestamp(6) null")
    private LocalDateTime createdAt;

    public NoticeListDTO toNoticeListDTO() {
    	return NoticeListDTO.builder()
    			.id(no).title(title).content(content).createdAt(createdAt)
    			.build();
    }

	public NoticeEditDTO toNoticeEditDTO() {
		return NoticeEditDTO.builder()
			.no(no)
			.title(title)
			.content(content)
			.build();
	}
	
	public void updateNotice(NoticeUpdateDTO dto) {
		this.title = dto.getTitle();
		this.content = dto.getContent();
	}
}