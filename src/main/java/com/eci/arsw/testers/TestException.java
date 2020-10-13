package com.eci.arsw.testers;

public class TestException extends Exception {

    public static final String DRIVER_NOT_SETUP = "Primero asigna un driver específico";

    public TestException(String msg) {
        super(msg);
    }

    public TestException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
