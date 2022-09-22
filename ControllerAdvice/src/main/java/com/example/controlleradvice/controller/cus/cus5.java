package com.example.controlleradvice.controller.cus;

public class cus5 extends RuntimeException{

    public cus5() {
        super();
    }

    public cus5(String message) {
        super(message);
    }

    public cus5(String message, Throwable cause) {
        super(message, cause);
    }

    public cus5(Throwable cause) {
        super(cause);
    }

    protected cus5(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
