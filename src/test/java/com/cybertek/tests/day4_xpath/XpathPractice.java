package com.cybertek.tests.day4_xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //absoloute
        WebElement userNameBox = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input"));
        userNameBox.sendKeys("tom");

        //relative
        driver.findElement(By.xpath("//input[@type='text']"));










    }
}
