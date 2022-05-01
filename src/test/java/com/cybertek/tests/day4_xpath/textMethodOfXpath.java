package com.cybertek.tests.day4_xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class textMethodOfXpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        WebElement text = driver.findElement(By.xpath("//h3[text()='Context Menu']"));

        String expectedText = "Context Menu";
        String actualText = text.getText();

        if(expectedText.equals(actualText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }






    }
}
