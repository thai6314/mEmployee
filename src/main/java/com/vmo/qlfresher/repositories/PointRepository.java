package com.vmo.qlfresher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer>{

}
