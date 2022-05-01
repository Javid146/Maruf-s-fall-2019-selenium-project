package com.cybertek.tests.day3_locators2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().window().maximize();

        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));

        String textVersionOfExample3 = example3.getText();////////////////////////////////////////////////////////////////

        System.out.println("PRINT #1: "+textVersionOfExample3);

        //linkText vs partialLinkText
        //I want to locate Example3 with only a part of it
        WebElement example3_2 = driver.findElement(By.partialLinkText("Example 3:"));

        String text = example3_2.getText();
        System.out.println("PRINT #2: "+text);

        WebElement tag = driver.findElement(By.xpath("//p[1]"));
        System.out.println("PRINT #3 = " + tag.getText());

        WebElement cybertekSchool = driver.findElement(By.tagName("h3"));
        //I can not print the above variable cybertekschool
        //because it is a webElement
        String textVersion = cybertekSchool.getText();
        System.out.println("PRINT #4: "+textVersion);

        WebElement example4 = driver.findElement(By.xpath("//a[@href='/dynamic_loading/4']"));
        System.out.println("example4.getText() = " + example4.getText());

        WebElement partial = driver.findElement(By.partialLinkText("Loading page title after 5"));// this only works with link (weblink) inside of page ////////////
        System.out.println("PRINT #5 = " + partial.getText());      }}

