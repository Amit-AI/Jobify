package com.site.joblisting.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleExceptions(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(exception.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.name());
        exceptionResponse.setTimeStamp(LocalDate.now().toString());
        exceptionResponse.setPath(request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> messageList = new ArrayList<>();

        for (ObjectError err : ex.getAllErrors()) {
            messageList.add(err.getDefaultMessage());
        }

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError(String.join(", ", messageList));
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        exceptionResponse.setTimeStamp(LocalDate.now().toString());
        exceptionResponse.setPath(request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
