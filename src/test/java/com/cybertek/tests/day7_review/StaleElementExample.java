package com.cybertek.tests.day7_review;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElementExample {
    public static void main(String[] args) throws InterruptedException {
        //main method to invoke thee tests
        nameMatchTest();
    }
    // each test will be a separate method
    /*
    1.open browser
    2.go to amazon
    3.search for any item
    4.remember the name of the first result
    5.click on the first result
    6.verify that product name is same in the product result
     */
    private static void nameMatchTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https:/www.amazon.com");
        String searchTerm = "disinfectant wipes";
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.submit();
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // FIND THE FIRST RESULT
       // WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        WebElement link = driver.findElement(By.xpath("//span[text()='Clorox Disinfecting Wipes Value Pack, 75 Ct Each, Pack of 3 (Package May Vary)']"));
        //System.out.println(firstResult.getText());
        link.click();
        Thread.sleep(4000);

//        // GET THE TEXT OF THE FIRST RESULT
      //  String expectedName = link.getText(); // TRYING TO INTERACT WITH ELEMENT FROM PREVIOUS PAGE
       // Thread.sleep(2000);

        WebElement productName = driver.findElement(By.id("productTitle"));
        Thread.sleep(2000);
        String actualName = productName.getText();
        System.out.println("actualName = " + actualName);
        String expected = "Clorox Disinfecting Wipes Value Pack, 75 Ct Each, Pack of 3 (Package May Vary)";

        if (actualName.equals(expected)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }



    }
}
