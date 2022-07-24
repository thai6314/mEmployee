package com.vmo.qlfresher.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.vmo.qlfresher.entities.Center;
import com.vmo.qlfresher.services.CenterService;

@RestController
@RequestMapping(path = "/company/center")
public class CenterController {

	@Autowired
	private CenterService centerService;

	@PostMapping(path = "/create", consumes = { "application/json" })
	public Center createCenter(@RequestBody @Valid Center center) {
		return centerService.create(center);
	}
	
	@PutMapping(path = "/update/{id}", consumes = { "application/json" })
	public Center updateCenter(@RequestBody @Valid Center center, @PathVariable(value = "id") int id) {
		return centerService.update(center,id);
	}

	@GetMapping("/list")
	public List<Center> getCenters() {
		return centerService.getAll();
	}
	
	@GetMapping("/detail/{id}")
	public Optional<Center> getCenterDetail(@PathVariable(value = "id") int id) {
		return centerService.getById(id);
	}

	
	@DeleteMapping("/delete/{id}")
	public Map<String, String> delete(@PathVariable(value = "id") int id) {
		return centerService.delete(id);
	}
	
	
}
