package com.taxcalc.exception;

public class NoSlabRateFoundException extends Exception {

    public NoSlabRateFoundException() {
        super();
    }

    public NoSlabRateFoundException(String message) {
        super(message);
    }

    public NoSlabRateFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSlabRateFoundException(Throwable cause) {
        super(cause);
    }

    public NoSlabRateFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
