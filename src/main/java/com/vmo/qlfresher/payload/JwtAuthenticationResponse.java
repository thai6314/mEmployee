package com.vmo.qlfresher.payload;

import java.io.Serializable;

import lombok.Data;

public class JwtAuthenticationResponse implements Serializable{
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwtToken;

	public JwtAuthenticationResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getToken() {
		return this.jwtToken;
	}

}
