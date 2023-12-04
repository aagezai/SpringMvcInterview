package com.facebooked.demofacebooked.ExceptionalHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;

@RestControllerAdvice
public class RestControllerAdviceFaceBooked {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }

    @ExceptionHandler({RuntimeException.class,ArithmeticException.class})
    public ResponseEntity<String> handleRuntimeException(RuntimeException e,ArithmeticException ae) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    }
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<String> handleRuntimeException(FileNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request --> File NotFOUnd");
    }
    @ExceptionHandler(FaceBookedException.class)
    public ResponseEntity<String> handleRuntimeException(FaceBookedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage()+" "+e.getMessage()+" \n"+e.getStackTrace()+"\n"+HttpStatus.NOT_FOUND);
    }
}
