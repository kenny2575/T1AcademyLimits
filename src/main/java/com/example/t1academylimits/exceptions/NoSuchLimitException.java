package com.example.t1academylimits.exceptions;

public class NoSuchLimitException extends RuntimeException {
    public NoSuchLimitException(Integer limit) {
        super("Не найден лимит с id " + limit);
    }
}
