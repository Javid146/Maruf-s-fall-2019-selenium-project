package com.cybertek.tests.day10_webelement;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() { driver = WebDriverFactory.getDriver("chrome"); }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    /*go to page radio buttons verify that none of the sports radio buttons are selected*/
    @Test
    public void listOfRadioButtons() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> sports = driver.findElements(By.name("sport"));

        System.out.println(sports.size());// elementlerin sayini print edir

        for (WebElement radioButton : sports) {
            Assert.assertFalse(radioButton.isSelected()); } }

    @Test
    public void getAllLinksTest() {
        driver.get("http://practice.cybertekschool.com");

        // get all the links in a page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        // get the text of each link and print
        for (WebElement link : links) { System.out.println(link.getText()); } }

    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels" + Keys.ENTER);

        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));

        Thread.sleep(2000);
        System.out.println("Number of results: " + allResults.size());

        System.out.println("First result: " + allResults.get(0).getText());
        System.out.println("Second result: " + allResults.get(1).getText());
        System.out.println("Last result: " + allResults.get(allResults.size() - 1).getText()); }

    /* go to http://practice.cybertekschool.com/radio_buttons
    verify the all sports checkboxes are NOT checked by default
    randomly click any sport
    verify that that sport is clicked
    verify that all others are not clicked
    repeat the last step for 5 times     */

    @Test
    public void radioTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> list = driver.findElements(By.name("sport"));

        System.out.println("verify none of them selected by default");
        System.out.println(list.size());
        //checking all the sport checkboxes are not checked
        for (int i = 0; i < list.size(); i++) {
            Assert.assertFalse(list.get(i).isSelected()); }

        System.out.println("Start randomly selecting radio buttons");
        for (int q = 0; q < 5; q++) {
            Thread.sleep(5000);
            Random ran = new Random();
            int num = ran.nextInt(4);
            list.get(num).click();
            System.out.println("Selecting button number: " + (num + 1));

            for (int i = 0; i < list.size(); i++) {
                if (i == num) {
                    Assert.assertTrue(list.get(num).isSelected());
                } else {
                    Assert.assertFalse(list.get(i).isSelected());
                } } }
    }}
