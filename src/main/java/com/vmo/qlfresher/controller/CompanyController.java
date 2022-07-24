package com.vmo.qlfresher.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.qlfresher.entities.Company;
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
}
