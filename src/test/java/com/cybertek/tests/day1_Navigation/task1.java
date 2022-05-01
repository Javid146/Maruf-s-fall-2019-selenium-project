package com.cybertek.tests.day1_Navigation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class task1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //1. Go to google webstite
        driver.get("https://www.google.com");

        //full screen
        driver.manage().window().maximize();

        String gglexpectedTitle = "Google";

        Thread.sleep(3000);
        driver.navigate().to("https://www.etsy.com/");

        String etsyExpectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Thread.sleep(3000);
        driver.navigate().back();  //google

        String actualGoogleTile = driver.getTitle();

        if(gglexpectedTitle.equals(actualGoogleTile)){
            System.out.println("pass");
        }else {
            System.out.println("FAIL");
            System.out.println("I expected title " + gglexpectedTitle);
            System.out.println("The actual URL is: " + actualGoogleTile ); }

        driver.navigate().forward();  //etsy

        String etsyActualTitile = driver.getTitle();

        if(etsyExpectedTitle.equals(etsyActualTitile)){
            System.out.println("pass");
        }else {
            System.out.println("FAIL");
            System.out.println("I expected Title" + etsyExpectedTitle);
            System.out.println("The actual URL is: " + etsyActualTitile );
        }
        driver.close();
    }}
