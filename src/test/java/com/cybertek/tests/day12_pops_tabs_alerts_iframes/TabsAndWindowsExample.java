package com.cybertek.tests.day12_pops_tabs_alerts_iframes;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindowsExample {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

//    @AfterMethod
//    public void afterTest() { driver.quit(); }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();///////////OPENS NEW WINDOW (NEW PAGE)

        // get all the available tabs
        Set<String> windowHandles = driver.getWindowHandles();/////////////////////////////////////////////////////////

        // print all the windows handles
        for (String windowHandle : windowHandles) {
            System.out.println("WINDOWHANDLE: "+windowHandle); }

        // get the id of current window/tab
        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);
        System.out.println("BEFORE SWITCHING");
        System.out.println("getTitle(): "+driver.getTitle());// gets titleof the page
        System.out.println(driver.findElement(By.tagName("h3")).getText());//gets the text of the element

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);////////////////////////////////////////////////////////////////////
            if (driver.getTitle().equals("New Window")) {
                break; } }

        System.out.println("AFTER SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText()); }
}
