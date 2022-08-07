package com.vmo.qlfresher.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.qlfresher.entities.Company;
import com.vmo.qlfresher.entities.Fresher;
import com.vmo.qlfresher.services.CompanyService;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping(path = "/create", consumes = {"application/json"})
	public Company createCompany(@RequestBody @Valid Company company) {
		return companyService.create(company);
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Map<String, String> deleteCompany(@PathVariable(value = "id") int id){
		return companyService.delete(id);
	}
	
	@PutMapping(path = "/add-fresher-to-center")
	public List<Fresher> addFresherToCenter(@RequestParam(value ="center_id") int centerId,
			@RequestParam(value ="fresher_id") int fresherId){
		return companyService.addFresherToCenter(centerId, fresherId);
	}
	
	@GetMapping(path = "/statistics-fresher-center")
	public Map<String, Integer> fresherStatistics(@RequestParam(value="company_id") int companyId){
		return companyService.FresherStatistics(companyId);
	}
	
	@GetMapping(path = "/statistics-point")
	public Map<String, Integer> pointStatistics(@RequestParam(value="company_id") int companyId){
		return companyService.pointStaistics(companyId);
	}
}
