package com.cybertek.tests.office_hours4;
import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframesExample extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        // switch iframe using id
        driver.switchTo().frame("iframeResult");
        //first find element in page
        System.out.println(driver.findElement(By.tagName("h2")).getText());//HTML Iframes
        // switch to iframe using webelement above. it means iframe below is within webelement above
        WebElement innerFrame = driver.findElement(By.cssSelector("iframe[src='demo_iframe.htm']"));
        driver.switchTo().frame(innerFrame);
        System.out.println(driver.findElement(By.tagName("h1")).getText());//This page is displayed in an iframe
        // change back to default content
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.cssSelector(".cm-m-xml.cm-meta")).getText());

    }
}
