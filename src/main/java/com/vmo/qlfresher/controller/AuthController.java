package com.vmo.qlfresher.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.qlfresher.payload.JwtAuthenticationResponse;
import com.vmo.qlfresher.payload.JwtRequest;
import com.vmo.qlfresher.security.CompanyDetail;
import com.vmo.qlfresher.security.JwtTokenUtil;
import com.vmo.qlfresher.services.CompanyDetailService;


@RestController
@RequestMapping(path = "/company")
public class AuthController {
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private CompanyDetailService companyDetailService;
	
	

	@PostMapping(path = "/auth/login", consumes = {"application/json"})
	public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
	
		 CompanyDetail companyDetail = (CompanyDetail) companyDetailService
				.loadUserByUsername(authenticationRequest.getEmail());
		logger.info(companyDetail.getPassword());

		 String token = jwtTokenUtil.generateToken(companyDetail);

		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}
	

}
