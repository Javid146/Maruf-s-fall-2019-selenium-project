package com.cybertek.tests.day8_review_2;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeExamples {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://ebay.com");

        // get title - gets words above link on the page
        System.out.println(driver.getTitle());//////////////////////////////////////////////////////////////////////////
        // get current url
        System.out.println(driver.getCurrentUrl());
        // get page source - long coding message about page
//        System.out.println("getPageSource: "+driver.getPageSource());///////////////////////////////////////////////////

        WebElement myEbayLink = driver.findElement(By.linkText("My eBay"));
        System.out.println(myEbayLink.getText());

        // get certain values of attributes of the webelement
        String classValue = myEbayLink.getAttribute("class");
        System.out.println(classValue);

        String href = myEbayLink.getAttribute("href");
        System.out.println(href);

        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("wooden spoon");
        System.out.println(input.getAttribute("value"));

        //getAttribute("innterHTML") --> returns text of the element
        System.out.println(myEbayLink.getAttribute("innerHTML"));/////////////////////////////////////////////////

        //getAttribute("outerHTML")) --> returns html information of element
        System.out.println(myEbayLink.getAttribute("outerHTML"));
        System.out.println(input.getAttribute("outerHTML")); }////////////////////////////////////////////////////
}
