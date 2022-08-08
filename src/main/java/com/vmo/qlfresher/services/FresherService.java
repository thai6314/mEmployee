package com.vmo.qlfresher.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmo.qlfresher.entities.Fresher;
import com.vmo.qlfresher.entities.Point;
import com.vmo.qlfresher.exception.BadRequestException;
import com.vmo.qlfresher.exception.ResponseException;
import com.vmo.qlfresher.repositories.FresherRepository;
import com.vmo.qlfresher.repositories.PointRepository;

@Service
public class FresherService {

	@Autowired
	private FresherRepository fresherRepo;

	@Autowired
	private PointRepository pointRepo;

	private ResponseException resException;

	public Fresher create(Fresher fresher) {
		Fresher fresherTemp = fresherRepo.findFresherByEmail(fresher.getEmail());
		if (fresherTemp == null) {
			return fresherRepo.save(fresher);

		} else {
			resException = new ResponseException("error", "This email dose not exist");
			throw new BadRequestException(resException);
		}

	}

	public Fresher update(Fresher fresher, int id) {
		Optional<Fresher> fresherTemp = fresherRepo.findById(id);
		if (fresherTemp.isEmpty()) {
			resException = new ResponseException("error", "This fresher does not exist");
			throw new BadRequestException(resException);
		} else {
			if (fresherRepo.findFresherByEmail(fresher.getEmail()) == null
					|| fresherTemp.orElseThrow().getEmail().equals(fresher.getEmail())) {
				fresherTemp.orElseThrow().setEmail(fresher.getEmail());
				fresherTemp.orElseThrow().setFullname(fresher.getFullname());
				fresherTemp.orElseThrow().setPhoneNumber(fresher.getPhoneNumber());
				fresherTemp.orElseThrow().setCenter(fresher.getCenter());
				fresherTemp.orElseThrow().setAddress(fresher.getAddress());
				fresherTemp.orElseThrow().setProgramingLanguage(fresher.getProgramingLanguage());

				return fresherRepo.save(fresherTemp.orElseThrow());
			} else {
				resException = new ResponseException("error", "This fresher name adready exists");
				throw new BadRequestException(resException);

			}
		}
	}

	public Map<String, String> delete(int id) {
		Map<String, String> result = new HashMap<String, String>();
		Optional<Fresher> fresher = fresherRepo.findById(id);
		if (fresher.isEmpty()) {
			resException = new ResponseException("error", "This center does not exist");
			throw new BadRequestException(resException);
		} else {
			fresherRepo.deleteById(id);
			result.put("success", "Delete successful");
			return result;
		}

	}

	public List<Fresher> getAllFresherByCenterId(int centerId) {
		List<Fresher> freshers = new ArrayList<>();
		freshers = fresherRepo.findAllFresherByCenterId(centerId);
		if (freshers.isEmpty()) {
			resException = new ResponseException("error", "Fresher not found");
			throw new BadRequestException(resException);
		} else
			return freshers;

	}

	public List<Fresher> getAllFresherByCompanyId(int companyId) {
		List<Fresher> freshers = new ArrayList<>();
		freshers = fresherRepo.findAllFresherByCompanyId(companyId);
		if (freshers.isEmpty()) {
			resException = new ResponseException("error", "Fresher not found");
			throw new BadRequestException(resException);
		} else
			return freshers;

	}

	public Fresher getFresherById(int id) {
		Optional<Fresher> fresher = fresherRepo.findById(id);
		if (fresher.isEmpty()) {
			resException = new ResponseException("error", "Fresher not found");
			throw new BadRequestException(resException);
		} else
			return fresher.orElseThrow();

	}

	public List<Fresher> getFresherByName(String fullname) {
		List<Fresher> freshers = new ArrayList<>();
		freshers = fresherRepo.findFresherByName(fullname);
		if (freshers.isEmpty()) {
			resException = new ResponseException("error", "Fresher not found");
			throw new BadRequestException(resException);
		} else
			return freshers;
	}

	public List<Fresher> getFresherByProgramingLanguage(String programingLanguage) {
		List<Fresher> freshers = new ArrayList<>();
		freshers = fresherRepo.findFresherByProgramingLanguage(programingLanguage);
		if (freshers.isEmpty()) {
			resException = new ResponseException("error", "Fresher not found");
			throw new BadRequestException(resException);
		} else
			return freshers;
	}

	public Fresher getFresherByEmail(String email) {
		Fresher fresher = fresherRepo.findFresherByEmail(email);
		if (fresher == null) {
			resException = new ResponseException("error", "Fresher not found");
			throw new BadRequestException(resException);
		} else
			return fresher;
	}

	public Point calculatePoint(Point point) {
		if (point.getPoint1() <= 0 || point.getPoint2() <= 0 || point.getPoint3() <= 0) {
			resException = new ResponseException("error", "point >= 0");
			throw new BadRequestException(resException);
		} else {
			float mediumScore = (point.getPoint1() + point.getPoint2() + point.getPoint3()) / 3;
			point.setMediumScore(mediumScore);

			pointRepo.save(point);
			return point;
		}

	}

}
