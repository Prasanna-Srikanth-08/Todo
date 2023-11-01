package com.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ErrorMessage exceptionHandler(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMsg(ex.getMessage());
		return errorMessage;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorMessage handleValidationExceptions(MethodArgumentNotValidException ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMsg(ex.getBindingResult().getAllErrors()
				.stream().map(ObjectError::getDefaultMessage)//lambda equivalent -> x->x.getDefaultMessage()
				.collect(Collectors.joining(", ")));
		return errorMessage;
	}
}