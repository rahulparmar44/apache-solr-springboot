package com.hashedin.broadcast.searchengine.exception;

import org.springframework.http.HttpStatus;

public class SolrException extends RuntimeException{

    String message;
    HttpStatus httpStatus;

    public SolrException( String message,HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
        this.message =  message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
