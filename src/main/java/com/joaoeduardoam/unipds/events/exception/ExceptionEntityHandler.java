package com.joaoeduardoam.unipds.events.exception;

import com.joaoeduardoam.unipds.events.dto.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {


    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException ex){
        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }

}


