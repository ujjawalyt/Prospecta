package com.prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntryNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myENFEHandler(WebRequest wr ,EntryNotFoundException enfe){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setLocalDateTime(LocalDateTime.now());
		error.setMessage(enfe.getMessage());
		error.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
	
}
