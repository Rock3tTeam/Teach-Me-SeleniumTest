package com.eci.arsw.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Drivers {
    CHROME("chrome", "chromedriver.exe"), FIREFOX("gecko", "geckodriver.exe"),
    EDGE("edge", "msedgedriver.exe");

    private final String name;
    private final String executableName;

    Drivers(String name, String executableName) {
        this.name = name;
        this.executableName = executableName;
    }

    public String getName() {
        return name;
    }

    public String getExecutableName() {
        return executableName;
    }

    public WebDriver getWebDriver() {
        System.setProperty("webdriver." + getName() + ".driver", "drivers/" + getExecutableName());
        WebDriver webDriver;
        if (getName().equals("chrome")) {
            webDriver = new ChromeDriver();
        } else if (getName().equals("gecko")) {
            webDriver = new FirefoxDriver();
        } else {
            webDriver = new EdgeDriver();
        }
        return webDriver;
    }
}
