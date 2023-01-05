package ru.scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order1 extends WebDriverSettings {

    @RunWith(Parameterized.class)
    public class formClass {
        private final String name;
        private final String secondName;
        private final String adress;
        private final String metro;
        private final String phone;
        private final String date;
        private final String rent;
        private final Boolean isBlack;
        private final Boolean isGrey;
        private final String comment;

        public formClass(String cityName, boolean isVisible) {
            this.name = name;
            this.secondName = secondName;
            this.adress = adress;
            this.metro = metro;
            this.phone = phone;
            this.date = date;
            this.rent = rent;
            this.isBlack = isBlack;
            this.isGrey = isGrey;
            this.comment = comment;

        }

        @Parameterized.Parameters
        public static Object[][] getCities() {
            return new Object[][] {
                    {
                            "Ольга", "Извекова", "Новосибирск", "Сокольники", "9526983712", "15.12.2022", "двое суток", true, false, "Везите скорее))"
                    },
                    {
                            "Иван", "Иванов", "Казань", "Белорусская", "9523659875", "25.12.2022", "сутки", false, true, "После 19-00"
                    },
            };
        }

        @Test
        public void firstTest() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://qa-scooter.praktikum-services.ru/");

            //нажали на кнопку "Заказать" вверху
            driver.findElement(By.className("Button_Button__ra12g")).click();

            //перешли на первую страницу формы
            WebDriverWait wait = new WebDriverWait(driver, 3);

            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div/div[1]")).sendKeys(name);
            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div/div[2]")).sendKeys(secondName);
            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div/div[3]")).sendKeys(adress);

            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div/div[4]")).click();
            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div/div/div/input[@value = 'Сокольники']")).click();

            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div/div[5]")).sendKeys(phone);

            //нажали на кнопку "Далее"
            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']")).click();

            //переход на вторую страницу формы
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[@id='root']/div/div/div/div[@class = 'Order_Header__BZXOb']")));

            //заполнили поля формы

            // клик по полю "Дата"
            driver.findElement(By.className("Input_Input__1iN_Z Input_Responsible__1jDKN react-datepicker-ignore-onclickoutside")).click();
            while(!driver.findElement(By.xpath("//span[@class = 'react-datepicker__current-month']")).getText().contains("декабрь")) {
                driver.findElement(By.xpath("//button[@class = 'react-datepicker__navigation react-datepicker__navigation--next'")).click();
            }
            int count = driver.findElements(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--015']")).size();
            for (int i = 0; i < count; i++) {
                String text = driver.findElements(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--015']")).get(i).getText();
                if (text.equalsIgnoreCase("15")) {
                    driver.findElements(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--015']")).get(i).click();
                }
            }

            //клик по выпадающему списку
            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div[@class = 'Dropdown-placeholder']")).click();
            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div/div/div[@class = 'Dropdown-placeholder is-selected']")).click();

            //клик по чек-боксу "Цвет самоката"
            driver.findElement(By.id("isBlack")).click();
            driver.findElement(By.id("isGrey")).click();

            //поле формы "Комментарий"
            driver.findElement(By.xpath("html/body/div[@id='root']/div/div/div/div[@class = 'Input_InputContainer__3NykH']")).sendKeys(comment);

            //подтверждение заказа
            driver.findElement(By.className("Order_ModalHeader__3FDaJ"));
            driver.findElement(By.xpath("//div[@class = 'Order_Buttons__1xGrp']/button[2]")).click();

        }
    }
}
