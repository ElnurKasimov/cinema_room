package com.hyperskill.cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(InvalidBoundaryException.class)
    public ResponseEntity<CustomErrorMessage> handleInvalidRowOrColumnNumber(
            InvalidBoundaryException e, WebRequest request) {
        CustomErrorMessage body = new CustomErrorMessage(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PurchasedException.class)
    public ResponseEntity<CustomErrorMessage> handlePurchased(
            PurchasedException e, WebRequest request) {
        CustomErrorMessage body = new CustomErrorMessage(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomErrorMessage> handleEntityNotFound(
            EntityNotFoundException e, WebRequest request) {
        CustomErrorMessage body = new CustomErrorMessage(e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
