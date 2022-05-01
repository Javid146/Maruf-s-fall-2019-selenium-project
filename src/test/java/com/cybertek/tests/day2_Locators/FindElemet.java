package com.cybertek.tests.day2_Locators;
        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        public class FindElemet {
            public static void main(String[] args) throws InterruptedException {

                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.get("https://cybertekschool.okta.com/");
                driver.manage().window().maximize();

                Thread.sleep(3000);
                WebElement emailBox =  driver.findElement(By.id("okta-signin-username"));

                emailBox.sendKeys("asiya@gmail.com");

                //write your password to the password text box

                Thread.sleep(2000);
                WebElement password = driver.findElement(By.id("okta-signin-password"));//////////////////////////////
                password.sendKeys("123abc"+Keys.ENTER);

                System.out.println("getTagName: "+password.getTagName());

            }
        }
