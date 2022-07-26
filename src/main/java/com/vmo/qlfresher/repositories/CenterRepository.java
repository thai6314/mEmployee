package com.vmo.qlfresher.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center,Integer>{

	public Center findCenterByName(String name);
	
	@Query("SELECT c FROM Center c WHERE c.company.id = :company_id")
	public List<Center> findCenterByCompanyId(@Param(value ="company_id")int companyId);
	
}