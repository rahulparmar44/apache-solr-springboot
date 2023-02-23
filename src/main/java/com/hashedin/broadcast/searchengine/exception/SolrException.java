package com.hashedin.broadcast.searchengine.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;

import java.util.Objects;


@Data
@AllArgsConstructor
public class SolrException extends RuntimeException{
    String message;
    HttpStatus httpStatus;
}
