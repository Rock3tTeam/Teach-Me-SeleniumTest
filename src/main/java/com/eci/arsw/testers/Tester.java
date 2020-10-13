package com.eci.arsw.testers;

import com.eci.arsw.drivers.Drivers;

import java.io.IOException;

public interface Tester {
    void setUpDriver(Drivers driver);

    void login(String username, String password) throws TestException;

    void showResults();

    void writeResults() throws IOException;

    void close() throws TestException;

    void reload() throws TestException;

}
