package com.e221.ecommerce.exception;

public class InvalidCurrencyException extends BusinessRuleException {
    public InvalidCurrencyException(String message) {
        super(message);
    }
}