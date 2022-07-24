package com.vmo.qlfresher.exception;


public class ResponseException {
	private String message;
	private String error;
	
	public ResponseException() {}
	
	public ResponseException(String error, String message) {
		this.error = error;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
