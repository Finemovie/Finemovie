package com.green.Finemovie.free.comment;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.green.Finemovie.free.FreeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SequenceGenerator(name = "gen_seq_comment", sequenceName = "seq_comment", initialValue = 1, allocationSize = 1)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Comments")
public class CommentEntity {
	
	@Id
	@GeneratedValue(generator = "gen_seq_comment", strategy = GenerationType.SEQUENCE)
	private long commentNo;
	
	@Column(nullable = false)
	private String commentWriter;
	
	@Column(nullable = false)
	private String commentPassword;
	
	@Column(columnDefinition = "LONGTEXT not null")
	private String comment;
	
	@CreationTimestamp
	@Column(columnDefinition = "timestamp(6) null" , nullable = false, updatable = false)
    private LocalDateTime createdDate;
    
	@ManyToOne
    @JoinColumn(name = "freeNo")  // freeBoards 테이블과의 관계를 나타내는 외래키
    private FreeEntity freeEntity;
    
	public void detachFreeEntity() {
		// ProcedureEntity와의 연결을 해제
        this.freeEntity = null;
	}
    
}
