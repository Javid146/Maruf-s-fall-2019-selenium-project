package com.cybertek.tests.day4_xpath;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ClicikvsSubmit {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        WebElement emailbox = driver.findElement(By.name("email"));
        //enter email --< sendKeys()
        emailbox.sendKeys("abc@gamil.com");

        WebElement submitBttn = driver.findElement(By.id("form_submit"));
        //submit email by clicking the "retrieve password"
        submitBttn.submit();

        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();/////////////////////////////////////////

        if(expectedURL.equals(actualURL)){
            System.out.println("test is passed");
        }else {
            System.out.println("test is failed");
        }
    driver.close();
    }}
