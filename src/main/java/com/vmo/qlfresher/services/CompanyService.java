package com.vmo.qlfresher.services;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmo.qlfresher.entities.Center;
import com.vmo.qlfresher.entities.Company;
import com.vmo.qlfresher.entities.Fresher;
import com.vmo.qlfresher.exception.BadRequestException;
import com.vmo.qlfresher.exception.ResponseException;
import com.vmo.qlfresher.repositories.CenterRepository;
import com.vmo.qlfresher.repositories.CompanyRepository;
import com.vmo.qlfresher.repositories.FresherRepository;
import com.vmo.qlfresher.repositories.PointRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CenterRepository centerRepo;

	@Autowired
	private FresherRepository fresherRepo;

	@Autowired
	private PointRepository pointRepo;

	private ResponseException responseException;

	public Company create(Company company) {
		if (companyRepo.findCompanyByName(company.getName()) == null) {
			company.setPassword(passwordEncoder.encode(company.getPassword()));

			return companyRepo.save(company);
		} else {
			responseException = new ResponseException("error", "This company name adready exists");
			throw new BadRequestException(responseException);

		}
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

	public List<Fresher> addFresherToCenter(int centerId, int fresherId) {
		Optional<Fresher> fresherTemp = fresherRepo.findById(fresherId);
		Optional<Center> centerTemp = centerRepo.findById(centerId);
		if (centerTemp.isEmpty()) {
			responseException = new ResponseException("error", "This center does not exist");
			throw new BadRequestException(responseException);
		} else if (fresherTemp.isEmpty()) {
			responseException = new ResponseException("error", "This fresher does not exist");
			throw new BadRequestException(responseException);
		} else {
			fresherTemp.orElseThrow().setCenter(centerTemp.orElseThrow());
			fresherRepo.save(fresherTemp.orElseThrow());
		}

		return fresherRepo.findAllFresherByCenterId(centerId);
	}

	public Map<String, Integer> FresherStatistics(int companyId) {
		List<Center> centers = centerRepo.findCenterByCompanyId(companyId);
		Map<String, Integer> amountFresher = new HashMap<String, Integer>();

		centers.forEach(center -> {
			amountFresher.put(center.getName(), fresherRepo.findAllFresherByCenterId(center.getId()).size());
		});

		return amountFresher;
	}

	public Map<String, Integer> pointStaistics(int companyId) {
		Map<String, Integer> amountPoint = new HashMap<String, Integer>();
		amountPoint.put("Less than 6.5", pointRepo.amountMedium((float) 6.5));
		amountPoint.put("Between 6.5 - 9", pointRepo.amountGood());
		amountPoint.put("Greater than or equal to 9", pointRepo.amountVeryGood(9));
		return amountPoint;
	}

	public UserDetails loadUserById(int id) {
		Optional<Company> company = companyRepo.findById(id);
		if (company.isEmpty()) {
			responseException = new ResponseException("error", "Company not found");
			throw new BadRequestException(responseException);
		}
		return (UserDetails) company.orElseThrow();
	}

}
