package com.vijay.portfolio.Validations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserValidation {

	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception){
		
		Map<String, String> errors =new HashMap<>();
		
		exception.getBindingResult().getAllErrors().forEach((error)->{
			String field = ((FieldError)error).getField();
			String defaultMessage = error.getDefaultMessage();
			errors.put(field, defaultMessage);
		});
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		
	}
	
}
