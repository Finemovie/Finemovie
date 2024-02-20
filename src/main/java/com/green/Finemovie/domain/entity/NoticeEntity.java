package com.green.Finemovie.domain.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.green.Finemovie.domain.dto.notice.NoticeListDTO;

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
    private long id;

    private String title;
    private String content;
    
    @CreationTimestamp
    @Column(columnDefinition = "timestamp(6) null")
    private LocalDate createdAt;

    public NoticeListDTO toNoticeListDTO() {
    	return NoticeListDTO.builder()
    			.id(id).title(title).content(content)
    			.build();
    }
}