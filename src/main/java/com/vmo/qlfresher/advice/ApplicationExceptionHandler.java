package com.vmo.qlfresher.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vmo.qlfresher.exception.BadRequestException;
import com.vmo.qlfresher.exception.ResponseException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handerInvalidAgrument(MethodArgumentNotValidException ex){
		
		
		Map<String, String> errorMap = new HashMap();
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public Map<String, String> handlerBusinessException(BadRequestException ex){
		Map<String, String> errorMap = new HashMap();
		ResponseException resReception = ex.getResponseException();
		errorMap.put(resReception.getError(), resReception.getMessage());
		return errorMap;
	}
}

