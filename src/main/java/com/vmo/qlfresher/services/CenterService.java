package com.vmo.qlfresher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmo.qlfresher.entities.Center;
import com.vmo.qlfresher.repositories.CenterRepository;

@Service
public class CenterService implements CrudService<Center>{
	
	@Autowired
	private CenterRepository centerRepo;

	@Override
	public Center create(Center center) {		
		return centerRepo.save(center);
	}

	@Override
	public Center update(Center center, int id) {
		
		return null;
	}

	@Override
	public Center getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Center> getAll() {
		return centerRepo.findAll();
		
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Center findCenterByName(String name) {
		return centerRepo.findCenterByName(name);
	}


	

}
