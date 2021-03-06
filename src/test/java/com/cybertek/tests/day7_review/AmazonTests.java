package com.cybertek.tests.day7_review;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TODO THIS SPECIFIC AMAZON TEST WILL THROW EXCEPTION
public class AmazonTests {
    // main method to invoke the tests
    public static void main(String[] args) throws InterruptedException {
        nameMatchTest();
        secondNameMatchTest(); }

    public static void secondNameMatchTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        String searchTerm = "disinfectant wipes";
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        // OPTION 1: enter search term and hit ENTER button
//        searchInput.sendKeys(searchTerm + Keys.ENTER);
        // OPTION 2: Enter search term and click the search button
        searchInput.sendKeys(searchTerm);
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        Thread.sleep(2000);
        WebElement secondResult = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        // it is printing the value
        System.out.println(secondResult.getText());
        // get the name of the second result
        String expectedName = secondResult.getText();
        secondResult.click();

        Thread.sleep(2000);
        WebElement productName = driver.findElement(By.id("productTitle"));
        String actualName = productName.getText();
        System.out.println(actualName);

        if (expectedName.equals(actualName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedName = " + expectedName);
            System.out.println("actualName = " + actualName);
        }
        driver.quit();
    }

    private static void nameMatchTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        String searchTerm = "disinfectant wipes";
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));

        searchInput.sendKeys(searchTerm);
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        Thread.sleep(2000);
        WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        System.out.println(firstResult.getText());
        // get the name of the first result
        String expectedName = firstResult.getText();
        firstResult.click();

        WebElement productName = driver.findElement(By.id("productTitle"));
        String actualName = productName.getText();
        System.out.println(actualName);

        if (expectedName.equals(actualName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedName = " + expectedName);
            System.out.println("actualName = " + actualName);
        }
        driver.quit();
    }
}
