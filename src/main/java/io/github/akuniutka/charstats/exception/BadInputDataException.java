package io.github.akuniutka.charstats.exception;

public class BadInputDataException extends RuntimeException {
    public BadInputDataException(String errorMessage) {
        super(errorMessage);
    }
}
