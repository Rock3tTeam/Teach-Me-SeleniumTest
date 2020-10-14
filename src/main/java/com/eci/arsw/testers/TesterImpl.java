package com.eci.arsw.testers;

import com.eci.arsw.drivers.Drivers;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TesterImpl implements Tester {

    private final String url;
    private WebDriver webDriver;

    public TesterImpl(String url) {
        this.url = url;
    }

    @Override
    public void setUpDriver(Drivers driver) {
        webDriver = driver.getWebDriver();
    }

    @Override
    @Test
    public void login(String username, String password) throws TestException {
        if (webDriver == null) throw new TestException(TestException.DRIVER_NOT_SETUP);
        webDriver.get(url);
        WebElement webElement = webDriver.findElement(By.id("username"));
        webElement.sendKeys(username);
        webElement = webDriver.findElement(By.id("password"));
        webElement.sendKeys(password);
        webDriver.findElement(By.id("sign_in")).click();
        waitOneSecond();
        assertEquals(url + "index.html", webDriver.getCurrentUrl());
    }

    @Override
    public void close() throws TestException {
        if (webDriver == null) throw new TestException(TestException.DRIVER_NOT_SETUP);
        webDriver.close();
    }

    @Override
    public void reload() throws TestException {
        if (webDriver == null) throw new TestException(TestException.DRIVER_NOT_SETUP);
        //webDriver.get(url + "/faces/comunidadInicio.xhtml");
    }

    @Override
    @Test
    public void search(String value) throws TestException {
        if (webDriver == null) throw new TestException(TestException.DRIVER_NOT_SETUP);
        WebElement webElement = webDriver.findElement(By.id("class_search"));
        webElement.sendKeys(value);
        webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div[1]/div[1]/form/div/a")).click();
        waitOneSecond();
        String xpathBeginning = "//*[@id=\"table_body\"]/tr[";
        String xpathFinish = "]/td[1]";
        for (int i = 0; i < 2; i++) {
            webElement = webDriver.findElement(By.xpath(xpathBeginning + (i+1) + xpathFinish));
            assertTrue(webElement.getText().contains(value));
        }
    }

    public WebElement element(By locator) {
        int timeoutLimitSeconds = 200;
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutLimitSeconds);
        try {
            //Espera a que el tiempo acordado hasta que elemento aparezca en la página
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new NoSuchElementException(locator.toString());
        }
        return webDriver.findElement(locator);
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
