package com.vmo.qlfresher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Fresher;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, Integer>{
	public Fresher findFresherByEmail(String email);
	
	public List<Fresher> findFresherByName(String fullname);
	
	@Query(value = "SELECT e FROM fresher e WHERE e.programing_language = :programing_language")
	public List<Fresher> findFresherByProgramingLanguage(@Param("programing_language") String programingLanguage);
	
	@Query(value = "SELECT e FROM fresher e WHERE e.center_id = :center_id")
	public List<Fresher> findAllFresherByCenterId(@Param("center_id") int centerId);
	
	@Query(value = "SELECT e FROM fresher e WHERE e.company_id = :company_id")
	public List<Fresher> findAllFresherByCompanyId(@Param("company_id") int companyId);
}
