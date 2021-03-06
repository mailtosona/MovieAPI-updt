package com.ssp.movie.api.error;

import com.ssp.movie.api.entity.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.Collections;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, NoRecommendationsException.class, IOException.class})
    public ResponseEntity<ApiResponse> MovieAPIException(Exception exception) {

        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false, Collections.emptyList());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
