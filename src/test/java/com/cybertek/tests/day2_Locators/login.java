package com.cybertek.tests.day2_Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    public static void main(String[] args) {

     WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

       driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
       driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        WebElement loginBttn = driver.findElement(By.id("_submit"));
        loginBttn.click();

        String expectedTitle = "Dashboard";
        String actulTitle = driver.getTitle();

        if(expectedTitle.equalsIgnoreCase(actulTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }







    }


}
