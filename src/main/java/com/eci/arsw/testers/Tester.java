package com.eci.arsw.testers;

import com.eci.arsw.drivers.Drivers;

public interface Tester {
    void setUpDriver(Drivers driver);

    void login(String username, String password) throws TestException;

    void close() throws TestException;

    void reload() throws TestException;

}
