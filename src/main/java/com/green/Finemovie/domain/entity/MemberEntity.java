package com.green.Finemovie.domain.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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

@Entity
@Table(name = "employee")
@SequenceGenerator(name = "gen_emp_seq", sequenceName = "emp_seq", allocationSize = 1)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberEntity {
	
	@Id
	@GeneratedValue(generator = "gen_emp_seq", strategy = GenerationType.SEQUENCE)
	private long memNo;
	
	@Column(nullable = false, unique = true)
	private String memUsername;
	
	@Column(nullable = false)
	private String memPassword;
	
	@Column(nullable = false)
	private String memName;
	
	@Column
	private Date memBirth;
	
	@Column
	private BigInteger memPhone;
	
	
	private String memRole;
	
	
	@CollectionTable(name = "memRole")
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private Set<MyRole> myRoles = new HashSet<>();
	
	public MemberEntity addRole(MyRole myRole) {
		myRoles.add(myRole);
		return this;
	}
	
	


	
}