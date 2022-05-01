package com.cybertek.tests.day1_Navigation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        //connect browser and driver
        //setup browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        driver.manage().window().maximize();

        String expectedTitle = "practice";

        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("I expected " + expectedTitle);
            System.out.println("The Actual title is " + actualTitle);
        }
        driver.close();












    }
}
