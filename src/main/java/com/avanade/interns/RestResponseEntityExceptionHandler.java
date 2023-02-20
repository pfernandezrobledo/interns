package com.avanade.interns;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.*;
import org.springframework.http.*;
import org.springframework.web.context.request.*;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler{

    @ExceptionHandler(value = { IllegalAccessException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return ResponseEntity.ok("");
    }
}