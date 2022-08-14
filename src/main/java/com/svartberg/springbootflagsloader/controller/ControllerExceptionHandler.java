package com.svartberg.springbootflagsloader.controller;

import com.svartberg.springbootflagsloader.exception.DirectoryDoesNotExist;
import com.svartberg.springbootflagsloader.exception.ErrorMessage;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(DirectoryDoesNotExist.class)
  public ResponseEntity<ErrorMessage> handleDirectoryDoesNotExistException(WebRequest res,
      DirectoryDoesNotExist ex) throws IOException {
    int statusCode = HttpStatus.BAD_REQUEST.value();
    ErrorMessage message = new ErrorMessage(
        statusCode,
        LocalDateTime.now(),
        ex.getMessage(),
        "validation exception");

    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
  }
}
