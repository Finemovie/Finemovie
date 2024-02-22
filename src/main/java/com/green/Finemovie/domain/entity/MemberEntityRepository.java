package com.green.Finemovie.domain.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {
	
	Optional<MemberEntity> findByMemUsername(String memUsername);

	boolean existsByMemUsername(String memUsername); //USername이 이미 존재하는지.
	
	MemberEntity findByMemName(String memName);
	
    boolean existsByMemName(String memName);

    MemberEntity findByMemNo(long memNo);
    
    List<MemberEntity> findAllByMemName(String memName);

	List<MemberEntity> findAllByMemRole(String memRole);


	
	


}