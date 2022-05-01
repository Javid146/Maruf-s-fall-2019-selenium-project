package com.cybertek.tests.day11_select_actions;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {
    WebDriver driver;
    JavascriptExecutor jse;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        jse = (JavascriptExecutor) driver; }

//    @AfterMethod
//    public void afterTest() { driver.quit(); }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");

        WebElement link = driver.findElement(By.cssSelector("a[href='/abtest']"));
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", link);////////////////////////////////////////////
        Thread.sleep(2000);}

    @Test
    public void sendKeysWithJS(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement input = driver.findElement(By.cssSelector("input[disabled]"));// finds the input box

        String text = "hi world";
//        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", input);////////////////////////////
        //above 'value' is text (hi world) and input is is the box in website to type value
        jse.executeScript("arguments[0].setAttribute('value', 'HELLO WORLD')",input); }}
