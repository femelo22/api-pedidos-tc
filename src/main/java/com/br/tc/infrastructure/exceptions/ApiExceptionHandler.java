package com.br.tc.infrastructure.exceptions;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Operation(hidden = true)
    public ResponseEntity<BindingError> objectNotFoundException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        BindingResult bindingResult = ex.getBindingResult();

        BindingError error = new BindingError(bindingResult);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Method Argument Not Valid Exception");
        error.setDate(LocalDateTime.now());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> entityNotFoundException(
            RuntimeException ex,
            HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(request.getRequestURI(), HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(UniqueViolationException.class)
    public ResponseEntity<ErrorMessage> entityUniqueViolation(
            RuntimeException ex,
            HttpServletRequest request
    ){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorMessage(request.getRequestURI(), HttpStatus.CONFLICT.value(), ex.getMessage()));
    }
}
