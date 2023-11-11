package io.github.akuniutka.charstats.controller;

import io.github.akuniutka.charstats.dto.ErrorMessage;
import io.github.akuniutka.charstats.exception.BadInputDataException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionTranslator {
    @ExceptionHandler(BadInputDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage translateBadInputDataException(BadInputDataException e) {
        return new ErrorMessage(-1, e.getMessage());
    }
}
