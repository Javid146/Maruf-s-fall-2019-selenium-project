package com.cybertek.tests.day3_locators2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();

        WebElement welcomeMassage = driver.findElement(By.tagName("h4"));

        String expectedMassage = "Welcome to the Secure Area. When you are done click logout below.";

        String actualWelcomeMassage = welcomeMassage.getText();//////////////////////////////////////////////
        System.out.println("actualWelcomeMassage = " + actualWelcomeMassage);

        if (expectedMassage.equalsIgnoreCase(actualWelcomeMassage)){
            System.out.println("PASSS");
        }else {
            System.out.println("Fail");
        }
//        driver.close();
    }}
