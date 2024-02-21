package com.green.Finemovie.free;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SequenceGenerator(name = "gen_seq_free", sequenceName = "seq_free", initialValue = 1, allocationSize = 1)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "FreeBoards")
public class FreeEntity {
	
	@Id
	@GeneratedValue(generator = "gen_seq_free", strategy = GenerationType.SEQUENCE)
	private long freeNo;
	
	@Column(nullable = false)
	private String writer;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "LONGTEXT not null")
	private String content;
	
	@Column(nullable = false)
	private int viewCount; //조회수 컬럼
	
	@CreationTimestamp
	@Column(columnDefinition = "timestamp(6) null" , nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(columnDefinition = "timestamp(6) null")
    private LocalDateTime updatedDate;
    
    @Column(columnDefinition = "CHAR(1) null default 'N'")
	private Character cancel; //게시글 삭제시 컬럼값 Y로 변경
    
    
    
    public FreeDTO toFreeDTO() {
    	return FreeDTO.builder()
    			.freeNo(freeNo)
    			.writer(writer)
    			.password(password)
    			.title(title)
    			.content(content)
    			.viewCount(viewCount)
    			.createdDate(createdDate)
				.updatedDate(updatedDate)
				.cancel(cancel)
    			.build();
    }
    
    
    
}
