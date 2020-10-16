package com.eci.arsw;

import com.eci.arsw.drivers.Drivers;
import com.eci.arsw.testers.Tester;
import com.eci.arsw.testers.TesterImpl;


public class Main {
    public static void main(String[] args) throws Exception {
        Tester tester = new TesterImpl("https://teache-me-front.herokuapp.com/");
        String username = "selenium@mail.com";
        String password = "selenium";
        //Por defecto fue realizado con Microsoft Edge, para mirar los demás drivers verificar enumeración de Drivers
        Drivers driver = Drivers.EDGE;
        tester.setUpDriver(driver);
        tester.failedLoginTest(username,"123");
        tester.reload();
        tester.login(username, password);
        tester.searchTest("MBDA",1);
        tester.createClassTest("Selenium","Clase de prueba para Selenium","5");
        tester.deleteClassTest("Selenium");
        tester.close();
    }
}

