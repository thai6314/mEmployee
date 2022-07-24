package com.vmo.qlfresher.exception;

import com.vmo.qlfresher.entities.Center;

public class BadRequestException extends RuntimeException{
	
	private ResponseException responseException;
	
	public BadRequestException(ResponseException responseException) {
		super();
		this.responseException = responseException;
	}

	public ResponseException getResponseException() {
		return responseException;
	}

	public void setResponseException(ResponseException responseException) {
		this.responseException = responseException;
	}
	
	
	
}
