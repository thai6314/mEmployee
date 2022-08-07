package com.vmo.qlfresher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	public Company findCompanyByName(String name);
	
	@Query("SELECT c FROM Company c WHERE c.email = :email")
	public Company finCompanyByEmail(@Param(value = "email")String email);
	
	
	
}
