package com.vijay.portfolio.ExceptionsHandler.UserExceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(UserNotFoundException exception, WebRequest request){
		
		Map<String, Object> errorDetails=new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", exception.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Object> handleDuplicateResourceException(DuplicateResourceException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("details", request.getDescription(false));
        
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT); // Return 409 Conflict
    }

}
