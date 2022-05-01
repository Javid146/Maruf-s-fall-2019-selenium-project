package com.cybertek.tests.day7_review;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonTestWithText {
    public static void main(String[] args) throws InterruptedException {
        //span[.='Selenium Testing Tools Cookbook - Second Edition']
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Thread.sleep(3000);
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        wait.until(ExpectedConditions.visibilityOf(searchInput));

        searchInput.sendKeys("selenium cookbook edition");
        searchInput.submit();

        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//span[starts-with(@class, 'a-size-medium a-color-base')]"));
        String actual = result.getText();


        String expected = "Selenium Testing Tools Cookbook - Second Edition";
        if(expected.equals(actual)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        driver.close();
    }
}
