package com.jsp.springboot.actor.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.actor.exception.ActorNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler 
	public ResponseEntity<ErrorStructure<String>> actorNotFoundByIdException(ActorNotFoundByIdException ex){
		
		ErrorStructure<String> errorStructure=new ErrorStructure<>();
		errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setData("Actor Object Not Found given Id doesn't Exists");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}

}
