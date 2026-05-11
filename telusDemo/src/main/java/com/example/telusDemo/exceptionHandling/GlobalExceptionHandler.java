package com.example.telusDemo.exceptionHandling;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.telusDemo.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponseDto>   handleCustomerNotFound( CustomerNotFoundException ex) {

        ErrorResponseDto error = new ErrorResponseDto( ex.getMessage(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto>   handleGenericException( Exception ex) {

        ErrorResponseDto error =new ErrorResponseDto("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}