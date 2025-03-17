package com.example.t1academylimits.controller.advice;

import com.example.t1academylimits.dto.ErrorResponse;
import com.example.t1academylimits.exceptions.IllegalOperationIdException;
import com.example.t1academylimits.exceptions.InsufficientFundsException;
import com.example.t1academylimits.exceptions.NoSuchLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class LimitControllerAdvice {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleMissingRequestException(MissingServletRequestParameterException exception) {
        log.warn("Ошибка обработки запроса");
        var response = new ErrorResponse("Problems with " + exception.getParameterName(), exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNoHandleFoundException(NoHandlerFoundException exception) {
        log.warn("Ошибка обработки запроса");
        var response = new ErrorResponse("Problem with path " + exception.getRequestURL(), exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleInsufficientFundsException(InsufficientFundsException exception) {
        log.warn("Ошибка обработки запроса {}", exception.getMessage());
        var response = new ErrorResponse("Недостаточно средств", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(IllegalOperationIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleIllegalOperationIdException(IllegalOperationIdException exception) {
        log.warn("Ошибка обработки запроса {}", exception.getMessage());
        var response = new ErrorResponse("Не найдена операция", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(NoSuchLimitException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleNoSuchLimitException(NoSuchLimitException exception) {
        log.warn("Ошибка обработки запроса {}", exception.getMessage());
        var response = new ErrorResponse("Не найден лимит", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}
