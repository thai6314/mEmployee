package com.vmo.qlfresher.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Fresher;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, Integer>{
	@Query("SELECT f FROM Fresher f WHERE f.email = :email")
	public Fresher findFresherByEmail(@Param("email") String email);
	
	@Query("SELECT f FROM Fresher f WHERE f.fullname = :fullname")
	public List<Fresher> findFresherByName(@Param("fullname") String fullname);
	
	@Query("SELECT f FROM Fresher f WHERE f.programingLanguage = :programing_language")
	public List<Fresher> findFresherByProgramingLanguage(@Param("programing_language") String programingLanguage);
	
	@Query("SELECT f FROM Fresher f WHERE f.center.id = :center_id")
	public List<Fresher> findAllFresherByCenterId(@Param("center_id") int centerId);
	
	@Query("SELECT f FROM Fresher f WHERE f.company.id = :company_id")
	public List<Fresher> findAllFresherByCompanyId(@Param("company_id") int companyId);
	
}
