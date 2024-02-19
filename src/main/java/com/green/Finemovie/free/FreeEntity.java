package com.green.Finemovie.free;

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
	
	@Column(nullable = false)
	private String content;
	
}
