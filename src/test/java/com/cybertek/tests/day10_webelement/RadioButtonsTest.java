package com.cybertek.tests.day10_webelement;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons"); }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void test1() {
        WebElement blue = driver.findElement(By.id("blue"));
        // isSelected --> returns true if element is selected
        System.out.println(blue.isSelected());

        // verify if the radio button is selected
        Assert.assertTrue(blue.isSelected());

        WebElement red = driver.findElement(By.id("red"));
        // prints red is not selected
        System.out.println(red.isSelected());
        // verifies if the statement is false. if it is false, it passes. if true it fails.
        Assert.assertFalse(red.isSelected()); }

    @Test
    public void test2() {
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));
        red.click();
        Assert.assertFalse(blue.isSelected());
        Assert.assertTrue(red.isSelected()); }}
