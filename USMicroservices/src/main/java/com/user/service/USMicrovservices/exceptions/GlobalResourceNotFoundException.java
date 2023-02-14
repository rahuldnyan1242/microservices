package com.user.service.USMicrovservices.exceptions;

import com.user.service.USMicrovservices.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalResourceNotFoundException {


    public ResponseEntity<ApiResponse> handlerGlobalResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
}
