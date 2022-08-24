package com.example.controlleradvice.controller.cus;

public class cus3 extends RuntimeException{

    public cus3() {
        super();
    }

    public cus3(String message) {
        super(message);
    }

    public cus3(String message, Throwable cause) {
        super(message, cause);
    }

    public cus3(Throwable cause) {
        super(cause);
    }

    protected cus3(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
