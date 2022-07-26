package com.vmo.qlfresher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer>{
	
	@Query("SELECT COUNT(p) FROM Point p WHERE p.mediumScore < :point")
	public int amountMedium(@Param(value = "point") float point);
	
	@Query("SELECT COUNT(p) FROM Point p WHERE p.mediumScore BETWEEN 6.5 AND 9")
	public int amountGood();
	
	@Query("SELECT COUNT(p) FROM Point p WHERE p.mediumScore >= :point")
	public int amountVeryGood(@Param(value = "point")float point);
}
