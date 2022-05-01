package com.cybertek.tests.day13_waits_and_synchronization;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExamples {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10); }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit(); }

    @Test
    public void test1TitleTest(){
        driver.get("https://google.com");
        System.out.println(driver.getTitle());

        driver.get("https://store.steampowered.com/");
        wait.until(ExpectedConditions.titleContains("Steam"));
        System.out.println(driver.getTitle()); }

    @Test
    public void test2WaitForVisible(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(username));
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe"); }

    // THIS WILL THROW EXCEPTION
    @Test
    public void test3WaitForVisibleFail(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        WebElement username = driver.findElement(By.xpath("//input[@type='username']"));
        WebElement password = driver.findElement(By.id("pwd"));

       wait.withTimeout(Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOf(username));
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe"); }

    @Test
    public void test4WaitForClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.tagName("button"));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");

        WebElement overlay = driver.findElement(By.className("loadingoverlay"));
        wait.until(ExpectedConditions.invisibilityOf(overlay));

        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click(); }

    @Test
    public void test4WaitForInvisible() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement myCalendar = driver.findElement(By.xpath("//a[@class='dashboard-btn  dashboard-link'][text()='My Calendar']"));
        Thread.sleep(5000);
        // wait until the element with class loader-mask is not visible
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-mask")));
        myCalendar.click(); }

    @Test
    public void test5Fluent() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait <WebDriver> fluentWait = new FluentWait<>(driver).////////////////////////////////////////////////////////////
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(5)).
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);

        WebElement submitBtn = fluentWait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']")));//////////////////////////////////
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        submitBtn.click(); }}
