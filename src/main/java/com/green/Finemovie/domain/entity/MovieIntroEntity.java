package com.green.Finemovie.domain.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import com.green.Finemovie.domain.dto.MovieIntroDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "MovieIntro")
@SequenceGenerator(name = "gen_seq_movieIntro", sequenceName = "seq_movieIntro", initialValue = 1, allocationSize = 1)
public class MovieIntroEntity {

	@Id
	@GeneratedValue(generator = "gen_seq_movieIntro", strategy = GenerationType.SEQUENCE)
	private Long no;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String content;
	private String writer;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@Column(nullable = false)
	private boolean type;
	@ColumnDefault("0")
	private long readCount;
	
	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	

	public MovieIntroDTO toDTO() {
		return MovieIntroDTO.builder()
				.no(no)
				.writer(writer)
				.title(title)
				.content(content)
				.createdAt(createdAt)
				.updatedAt(updatedAt)
				.type(type)
				.readCount(readCount)
				.build();
	}
}
