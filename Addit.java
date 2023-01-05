package ru.scooter;

import jdk.jfr.internal.MirrorEvent;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addit extends WebDriverSettings {

        @Test
        public void Addit1() {

            // вход на главную страницу
            driver.get("https://qa-scooter.praktikum-services.ru/");

            //нажали на кнопку "Заказать" вверху
            MirrorEvent By;
            driver.findElement(By.className("Button_Button__ra12g")).click();

            //перешли на первую страницу формы
            WebDriverWait wait = new WebDriverWait(driver, 10);

            //нажали на логотип "Самокат"
            driver.findElement(By.xpath("//a[@class = 'Header_LogoScooter__3lsAR']/img")).click();

            //перешли на главную страницу
            WebDriverWait wait1 = new WebDriverWait(driver, 10);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));

        }

    }
