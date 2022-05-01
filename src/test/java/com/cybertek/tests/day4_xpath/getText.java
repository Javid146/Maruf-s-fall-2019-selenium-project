package com.cybertek.tests.day4_xpath;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.jar.JarOutputStream;

public class getText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        WebElement emailbox = driver.findElement(By.name("email"));
        emailbox.sendKeys("abc@gamil.com");

        WebElement submitBttn = driver.findElement(By.id("form_submit"));
        //submit email by clicking the "retrive password"
        submitBttn.submit();

        String expectedText = "Your e-mail's been sent!";
        WebElement message = driver.findElement(By.name("confirmation_message"));

        //getText() -->
        String ActualText = message.getText();

        if (expectedText.equals(ActualText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }










    }
}
