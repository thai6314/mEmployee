package com.vmo.qlfresher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vmo.qlfresher.entities.Company;
import com.vmo.qlfresher.exception.BadRequestException;
import com.vmo.qlfresher.exception.ResponseException;
import com.vmo.qlfresher.repositories.CompanyRepository;
import com.vmo.qlfresher.security.CompanyDetail;

@Service
public class CompanyDetailService implements UserDetailsService {
	@Autowired
	private CompanyRepository companyRepo;
	@Autowired
	private ResponseException responseException;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Company company = companyRepo.finCompanyByEmail(email);
		
		if (company == null) {
			responseException = new ResponseException("error", "Company not found");
			throw new BadRequestException(responseException);
		}else {
			CompanyDetail companyDetail = new CompanyDetail(company);
			return companyDetail;
		}
		
	}

}
