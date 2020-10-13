package com.eci.arsw;

import com.eci.arsw.drivers.Drivers;
import com.eci.arsw.testers.Tester;
import com.eci.arsw.testers.TesterImpl;


public class Main {
    public static void main(String[] args) throws Exception {
        Tester tester = new TesterImpl("https://teache-me-front.herokuapp.com/");
        String username = "juan@gmail.com";
        String password = "prueba";
        //Por defecto fue realizado con Microsoft Edge, para mirar los demás drivers verificar enumeración de Drivers
        Drivers driver = Drivers.EDGE;
        tester.setUpDriver(driver);
        tester.login(username, password);
        tester.close();
    }
}

