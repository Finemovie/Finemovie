package com.green.Finemovie.free.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentEntityRepository extends JpaRepository<CommentEntity, Long>{

	@Modifying
    @Query("DELETE FROM CommentEntity c WHERE c.freeEntity.freeNo = :freeNo")
    void deleteByFreeNo(@Param("freeNo") long freeNo);
	
}
