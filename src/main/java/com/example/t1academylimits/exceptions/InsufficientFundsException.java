package com.example.t1academylimits.exceptions;

import com.example.t1academylimits.model.Limits;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException(Limits limits) {
        super("Не достаточно средств. Остаток свободных средств: " + limits.getAmount().subtract(limits.getHold()));
    }
}
