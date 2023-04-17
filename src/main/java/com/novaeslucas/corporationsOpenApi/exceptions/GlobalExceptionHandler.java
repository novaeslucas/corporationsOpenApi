package com.novaeslucas.corporationsOpenApi.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMessage());
        details.add(builder.toString());

        HttpStatus httpStatus = HttpStatus.valueOf(status.value());

        ErrorDTO error = new ErrorDTO();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(status.value());
        error.setErrorDetails(details);
        error.setPath(request.getContextPath());
        error.setMostSpecificCause(ex.getMostSpecificCause().getMessage());
        error.setHttpStatus(httpStatus);

        LOGGER.error("GlobalExceptionHandler | handleHttpMessageNotReadable", error);


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}