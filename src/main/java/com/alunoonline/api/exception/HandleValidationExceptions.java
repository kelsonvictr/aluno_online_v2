package com.alunoonline.api.exception;

import com.alunoonline.api.model.dtos.ErrorDTO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Order
@Log4j2
@ControllerAdvice
public class HandleValidationExceptions {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(Exception e) {

        ErrorDTO erroCapturado =
                ErrorDTO.builder() //
                        .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()) //
                        .detalhes(e.getMessage())
                        .build();

       log.info("Erros", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroCapturado);
    }


    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(NoSuchElementException e) {

        ErrorDTO erroCapturado =
                ErrorDTO.builder() //
                        .error(HttpStatus.NOT_FOUND.getReasonPhrase()) //
                        .detalhes(e.getMessage())
                        .build();

        log.info("Erros", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroCapturado);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(MethodArgumentNotValidException e) {


        List<String> constraintsViolated = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " - " + error.getDefaultMessage())
                .collect(Collectors.toList());

        constraintsViolated.addAll(
                e.getBindingResult().getGlobalErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList())
        );

        ErrorDTO erroCapturado = ErrorDTO.builder()
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .detalhes(constraintsViolated.toString())
                .build();


        log.info("Erros", constraintsViolated);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroCapturado);
    }


}