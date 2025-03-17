package com.example.t1academylimits.exceptions;

import java.util.UUID;

public class IllegalOperationIdException extends RuntimeException {
    public IllegalOperationIdException(UUID operationId) {
        super("Не найдена операция " + operationId.toString());
    }
}
