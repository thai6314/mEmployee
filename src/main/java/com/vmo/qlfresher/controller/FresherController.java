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
import org.springframework.web.bind.annotation.RestController;

import com.vmo.qlfresher.entities.Fresher;
import com.vmo.qlfresher.entities.Point;
import com.vmo.qlfresher.services.FresherService;

@RestController
@RequestMapping(path = "/company")
public class FresherController {
	
	@Autowired
	private FresherService fresherService;
	
	@PostMapping(path = "/fresher/create", consumes = "application/json")
	public Fresher create(@RequestBody @Valid Fresher fresher) {
		return fresherService.create(fresher);
	}
	
	@PutMapping(path = "/fresher/update", consumes = "application/json")
	public Fresher update(@RequestBody @Valid Fresher fresher, @PathVariable(value = "id") int id) {
		return fresherService.update(fresher, id);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Map<String, String> delele(@PathVariable(value = "id") int id){
		return fresherService.delete(id);
	}
	
	@GetMapping(path = "/center/fresher/list/{center_id}")
	public List<Fresher> getAllFresherByCenterId(@PathVariable(value = "center_id") int centerId){
		return fresherService.getAllFresherByCenterId(centerId);
	}
	
	@GetMapping(path = "/fresher/list/{center_id}")
	public List<Fresher> getAllFresherByCompanyId(@PathVariable(value = "company_id") int companyId){
		return fresherService.getAllFresherByCenterId(companyId);
	}
	
	@GetMapping(path = "/frehser/detail/{id}")
	public Fresher getDetail(@PathVariable(value = "id") int id) {
		return fresherService.getFresherById(id);
	}
	
	@PostMapping(path = "/fresher/calulate", consumes = "application/json")
	public Point calculatePoint(@RequestBody Point point) {
		return fresherService.calculatePoint(point);
	}

}
