package com.hashedin.broadcast.searchengine.exception;

import com.fasterxml.jackson.core.JacksonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        if (ex.getMessage().contains("Could not connect to ZooKeeper"))
            errorDetails.setMessage("Zookeeper port not found, please provide correct zookeeper port");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SolrException.class)
    public ResponseEntity<?> solrExceptionHandler(SolrException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, ex.getHttpStatus());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<?> restClientExceptionHandler(RestClientException ex, WebRequest request) {

        String msg = "Something went wrong";
        ErrorDetails errorDetails = new ErrorDetails(new Date(), msg, request.getDescription(false));
        ;
        if (Objects.requireNonNull(ex.getMessage()).contains("Connection refused")) {
            msg = "Solr port not found, please provide correct solr port";
            errorDetails = new ErrorDetails(new Date(), msg, request.getDescription(false));

        }
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JacksonException.class)
    public ResponseEntity<?> jsonParseExceptionHandler(JacksonException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Json parsing error", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
