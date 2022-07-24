package com.vmo.qlfresher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	public Company findCompanyByName(String name);
	
}
