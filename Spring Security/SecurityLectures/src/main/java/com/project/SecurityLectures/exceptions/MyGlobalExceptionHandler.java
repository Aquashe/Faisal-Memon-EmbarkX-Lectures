package com.project.SecurityLectures.exceptions;

import com.project.SecurityLectures.jwt.AuthEntryPointJwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyGlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> myAuthenticationException(AuthenticationException authenticationException) {
        logger.error("Message : {} ", authenticationException.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.UNAUTHORIZED.value());
        response.put("error", "Unauthorized");
        response.put("message", authenticationException.getMessage());
        response.put("path", "/signin");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> myMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        logger.error("Message : {} ", methodArgumentNotValidException.getMessage());
        Map<String, String> response = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(
                error -> {
                    String fieldName = error.getField();
                    String errorMessage = error.getDefaultMessage();
                    response.put(fieldName, errorMessage);
                }
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
