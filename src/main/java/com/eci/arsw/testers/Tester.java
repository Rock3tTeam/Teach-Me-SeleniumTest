package com.eci.arsw.testers;

import com.eci.arsw.drivers.Drivers;

public interface Tester {
    void setUpDriver(Drivers driver) throws TestException;

    void login(String username, String password) throws TestException;

    void failedLoginTest(String username, String password) throws TestException;

    void close() throws TestException;

    void reload() throws TestException;

    void searchTest(String value, int amount) throws TestException;

    void createClassTest(String className, String classDescription, String classCapacity) throws TestException;

    void deleteClassTest(String value) throws TestException;
}
