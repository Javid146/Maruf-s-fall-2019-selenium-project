package com.cybertek.tests.office_hours4;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptExecutorExample extends TestBase {

    @Test
    public void type() {
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Dynamic Controls")).click();
//        inputField = driver.findElement(webdriver.By.id('gbqfq'));
//        driver.executeScript("arguments[0].setAttribute('value', '" + longstring +"')", inputField);
        WebElement webElement = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text = "hello";                //line below means place value of String (text) inside of webelement in the webpage
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", webElement); }//////////////////////////////////////

    @Test
    public void highlight() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.tagName("h1"));
        highlight(text);

        List<WebElement> list = driver.findElements(By.cssSelector("li>a"));//finds all links in webpage
        for (WebElement link : list) {
            highlight(link); }}//this line executes method below and puts all links in webpage in red/yellow frame

    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();   //line below puts red/yellow colored frame around an element in webpage
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);/////////////////////////
        Thread.sleep(200);
        jse.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 10px solid red;');", element);
        Thread.sleep(200); }}
