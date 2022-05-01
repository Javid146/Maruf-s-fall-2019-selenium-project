package com.cybertek.tests.office_hours4;
import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesPractice extends TestBase {

    @BeforeMethod
    public void setUpTests() throws InterruptedException {
        driver.get("https://www.mockaroo.com/");
        driver.findElement(By.name("num_rows")).clear();
        driver.manage().window().maximize();
        driver.findElement(By.name("num_rows")).sendKeys("10");

        driver.findElement(By.xpath("//span[@class='MuiButton-label'][text()='Preview']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().parentFrame(); }

    @Test
    public void testHeaderCount() {
        WebElement table = driver.findElement(By.xpath("//table"));
        System.out.println(table.getText());
        // get all the in the table
        List<WebElement> headers = driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(), 6);}
    /*
    verify that value of each entry under gender column is equal to Male or Female
     */
    @Test
    public void verifyGender() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> allGenders = driver.findElements(By.xpath("//table[@style]/tbody/tr/td[5]"));
        System.out.println(allGenders.size());
        Thread.sleep(3000);
        // go through the list
        // verify that values are either Male or Female
        for (WebElement gender : allGenders) {
            String actual = gender.getText();
            System.out.println(actual);
            Assert.assertTrue(actual.equals("Male")||actual.equals("Polygender")||actual.equals("Agender")||actual.equals("Genderfluid")||actual.equals("Non-binary")||actual.equals("Bigender") ||actual.equals("Genderqueer")||actual.equals("Female")); } }}
