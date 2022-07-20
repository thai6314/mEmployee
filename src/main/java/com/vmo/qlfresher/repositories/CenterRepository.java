package com.vmo.qlfresher.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center,Integer>{
	
	public Center findCenterByName(String name);
}
