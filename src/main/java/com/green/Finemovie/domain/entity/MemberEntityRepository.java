package com.green.Finemovie.domain.entity;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {
	
	Optional<MemberEntity> findByEmpUsername(String empUsername);

	boolean existsByEmpUsername(String empUsername); //USername이 이미 존재하는지.
	
	MemberEntity findByEmpName(String empName);
	
    boolean existsByEmpName(String empName);

    MemberEntity findByEmpNo(long empNo);
    
    List<MemberEntity> findAllByEmpName(String empName);

	List<MemberEntity> findAllByEmpRole(String empRole);


	
	


}