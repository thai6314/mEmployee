package com.vmo.qlfresher.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.qlfresher.entities.Center;
import com.vmo.qlfresher.services.CenterService;

@RestController

public class CenterController {

	@Autowired
	private CenterService centerService;

	@PostMapping(path = "/create", consumes = { "application/json" })
	public Center createCenter(@RequestBody @Valid Center center) {
		return centerService.create(center);
	}

	@GetMapping("/center")
	public List<Center> getCenters() {
		
		return centerService.getAll();
	}
}
