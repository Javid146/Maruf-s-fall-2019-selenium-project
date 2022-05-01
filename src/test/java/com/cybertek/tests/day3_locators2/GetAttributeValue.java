package com.cybertek.tests.day3_locators2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        WebElement unername =driver.findElement(By.name("username"));

        //<input type="text" name="username">  Here type is attribute and its value is "text"
       String velueOfType =  unername.getAttribute("type");////////////////////////////////////////////////////////

        System.out.println("Value of type is: " +  velueOfType);

        // <button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>
        WebElement loginbttn = driver.findElement(By.id("wooden_spoon"));

        //i want to print class attributes value
        System.out.println(loginbttn.getAttribute("class"));//one of attributes within loginbttn element is called class and its value is "btn btn-primary"
    }
}
