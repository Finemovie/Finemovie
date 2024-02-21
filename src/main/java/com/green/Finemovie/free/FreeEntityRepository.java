package com.green.Finemovie.free;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FreeEntityRepository extends JpaRepository<FreeEntity, Long>{
	
	
	@Query("SELECT f FROM FreeEntity f " +
		       "WHERE LOWER(f.writer) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
		       "LOWER(f.title) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
		       "LOWER(CAST(f.freeNo AS string)) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
		       "LOWER(f.content) LIKE LOWER(CONCAT('%', :search, '%'))")
	Page<FreeEntity> findByFreeContainingIgnoreCase(@Param("search") String keyword, Pageable pageable);

}
