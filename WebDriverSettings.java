package ru.scooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.getProperty("WebDriver.chrome.driver", "/WebDriver/bin");
        driver = new ChromeDriver();
        System.out.println("test start");
    }

    @After
    public void close() {
        System.out.println("test close");
        driver.quit();
    }

}
