package com.vmo.qlfresher.services;

import java.util.HashMap;
import	org.springframework.security.crypto.password.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmo.qlfresher.entities.Company;
import com.vmo.qlfresher.exception.BadRequestException;
import com.vmo.qlfresher.exception.ResponseException;
import com.vmo.qlfresher.repositories.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private ResponseException responseException;
	
	public Company create(Company company) {
		if(companyRepo.findCompanyByName(company.getName()) == null) {
			company.setPassword(passwordEncoder.encode(company.getPassword()));
			
			return companyRepo.save(company);
		}
		else {
			responseException = new ResponseException("error","This company name adready exists");
			throw new BadRequestException(responseException);
			
		}
	}

	public Company update(Company company, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Company getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Company> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<String, String> delete(int id) {
		Map<String, String> result = new HashMap<String, String>();
		Optional<Company> company = companyRepo.findById(id);
		if (company.isEmpty()) {
			responseException = new ResponseException("error", "This company does not exist");
			throw new BadRequestException(responseException);
		} else {
			companyRepo.deleteById(id);
			result.put("success", "Delete successful");
			return result;
		}
	}

}
