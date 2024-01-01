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

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .error(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.name())
                .path(request.getDescription(false))
                .build();

        exception.printStackTrace();

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> messageList = new ArrayList<>();

        for (ObjectError err : ex.getAllErrors()) {
            messageList.add(err.getDefaultMessage());
        }

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .error(String.join(", ", messageList))
                .status(HttpStatus.BAD_REQUEST.name())
                .path(request.getDescription(false))
                .build();

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> userAlreadyExistsException(UserAlreadyExistsException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .error(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .path(request.getDescription(false))
                .build();

        ex.printStackTrace();

        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
