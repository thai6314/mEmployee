package com.vmo.qlfresher.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmo.qlfresher.entities.Center;
import com.vmo.qlfresher.exception.BadRequestException;
import com.vmo.qlfresher.exception.ResponseException;
import com.vmo.qlfresher.repositories.CenterRepository;

@Service
public class CenterService {

	@Autowired
	private CenterRepository centerRepo;

	private ResponseException responseException;

	public Center create(Center center) {
		if (centerRepo.findCenterByName(center.getName()) == null) {
			return centerRepo.save(center);
		} else {
			responseException = new ResponseException("error", "This center name adready exists");
			throw new BadRequestException(responseException);
		}
	}

	public Center update(Center center, int id) {
		Optional<Center> centerTemp = centerRepo.findById(id);
		if (centerTemp.isEmpty()) {
			responseException = new ResponseException("error", "This center does not exist");
			throw new BadRequestException(responseException);
		} else if (centerRepo.findCenterByName(center.getName()) == null
				|| centerTemp.orElseThrow().getName().equals(center.getName())) {
			centerTemp.orElseThrow().setEmail(center.getEmail());
			centerTemp.orElseThrow().setName(center.getName());
			centerTemp.orElseThrow().setDescription(center.getDescription());

			return centerRepo.save(centerTemp.orElseThrow());
		} else {
			responseException = new ResponseException("error", "This center name adready exists");
			throw new BadRequestException(responseException);
		}

	}

	public Optional<Center> getById(int id) {
		Optional<Center> center = centerRepo.findById(id);
		if (center.isEmpty()) {
			responseException = new ResponseException("error", "This center does not exist");
			throw new BadRequestException(responseException);
		}
		return center;
	}

	public List<Center> getAll() {
		List<Center> centers = new ArrayList<>();
		centers = centerRepo.findAll();
		if (centers.isEmpty()) {
			responseException = new ResponseException("error", "Center not found");
			throw new BadRequestException(responseException);
		}
		return centerRepo.findAll();

	}

	public Map<String, String> delete(int id) {
		Map<String, String> result = new HashMap<String, String>();
		Optional<Center> center = centerRepo.findById(id);
		if (center.isEmpty()) {
			responseException = new ResponseException("error", "This center does not exist");
			throw new BadRequestException(responseException);
		} else {
			centerRepo.deleteById(id);
			result.put("success", "Delete successful");
			return result;
		}

	}

	public Center findCenterByName(String name) {
		return centerRepo.findCenterByName(name);
	}

}
