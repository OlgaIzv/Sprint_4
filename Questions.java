package ru.scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;

public class Questions extends WebDriverSettings {

    @Test
    public void Questions() {

        // вход на главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //нашли куки и нажали на кнопку
        driver.findElement(By.id("rcc-confirm-button")).click();

        //нашли раздел "Вопросы о важном"

        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        //проверили все выпадающие списки

        driver.findElement(By.id("accordion__heading-0")).click();

        driver.findElement(By.id("accordion__heading-1")).click();

        driver.findElement(By.id("accordion__heading-2")).click();

        driver.findElement(By.id("accordion__heading-3")).click();

        driver.findElement(By.id("accordion__heading-4")).click();

        driver.findElement(By.id("accordion__heading-5")).click();

        driver.findElement(By.id("accordion__heading-6")).click();

        driver.findElement(By.id("accordion__heading-7")).click();


    }
}
